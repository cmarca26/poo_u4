package model;

public interface CSVSerializable {
    // Single Responsibility: Cada clase implementa su propia serialización
    String[] toCSV();
    void fromCSV(String[] data);
}
