package excelium.model.enums;

public enum Platform {
    /**
     * Get list choice.
     *
     * @return the list choice
     */
    public static String[][] getListChoice() {
        String[][] listChoice = new String[Platform.values().length][2];
        int i = 0;
        for (Platform t : Platform.values()) {
            listChoice[i++] = new String[]{t.name(), t.getText()};
        }
        return listChoice;
    }
}
