package model;

/**
 * Represents an Exception that will be thrown when some Tile is already
 * occupied and is needed to be empty.
 */
class TileAlreadyOccupiedException extends Exception {

    /**
     * Public constructor.
     *
     * @param message the message carried by this Exception.
     */
    public TileAlreadyOccupiedException(String message) {
        super(message);
    }
}
