package br.com.alura.screensound.service;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WikipediaQueryService {

    public static String getArtistDetails(String artistName) {
        try {
            String encodedName = URLEncoder.encode(artistName, StandardCharsets.UTF_8);
            String url = "https://en.wikipedia.org/api/rest_v1/page/summary/" + encodedName;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("User-Agent", "ScreenSoundApp/1.0 (Java)")
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                int extractIndex = response.body().indexOf("\"extract\":\"");
                if (extractIndex != -1) {
                    int start = extractIndex + 11;
                    int end = response.body().indexOf("\",\"extract_html\"", start);
                    if (end == -1) end = response.body().indexOf("\"}", start);
                    return response.body().substring(start, end).replace("\\\"", "\"");
                }
            }
            return "No biography found on Wikipedia for: " + artistName;
        } catch (Exception e) {
            return "Error querying Wikipedia: " + e.getMessage();
        }
    }
}