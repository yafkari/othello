package esi.atl.g52196.model;

/**
 *
 * @author g52196
 */
public interface Model {
    
    void initialize();
    
    Board getBoard();
    
    PlayerColor getCurrentColor();
    
    int getScore(PlayerColor color);
}
