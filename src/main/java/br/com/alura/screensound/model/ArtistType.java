package br.com.alura.screensound.model;

public enum ArtistType {
    SOLO,
    DUO,
    BAND;

    public static ArtistType fromString(String text) {
        for (ArtistType type : ArtistType.values()) {
            if (type.name().equalsIgnoreCase(text)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid artist type: " + text);
    }
}