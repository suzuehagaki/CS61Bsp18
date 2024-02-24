package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {

    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        ter.initialize(50, 50);
        TETile[][] world = new TETile[50][50];
        for (int x = 0; x < 50; x += 1) {
            for (int y = 0; y < 50; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }
        Position p = new Position(10,10);
        addHexagon(world, p, 4, Tileset.FLOWER);
        ter.renderFrame(world);
    }

    private static class Position {
        public int x;
        public int y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void addHexagon(TETile[][] world, Position p, int s, TETile t) {
        int length, index;
        for (int i = 0; i < s; i += 1) {
            index = p.x - i;
            length = s + 2 * i;
            for (int j = 0 ; j < length; j += 1) {
                world[index][p.y + i] = t;
                index += 1;
            }
        }
        for (int i = 0; i < s; i += 1) {
            index = p.x - s + i + 1;
            length = 3 * s - 2 * i - 2;
            for (int j = 0 ; j < length; j += 1) {
                world[index][p.y + i + s] = t;
                index += 1;
            }
        }
    }
}
