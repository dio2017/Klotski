package com.example.android.klotski;
import java.util.ArrayList;
import java.util.List;

public class BoardParser {

    public static List<Piece> parse(String map) {

        List<Piece> blocks = new ArrayList<>();

        String[] temp = map.split(",");
        int count = temp.length / 3;

        for (int i = 0; i < count; i++) {
            int type = Integer.parseInt(temp[i * 3]);
            int posX = Integer.parseInt(temp[i * 3 + 1]);
            int posY = Integer.parseInt(temp[i * 3 + 2]);
            blocks.add(new Piece(Piece.Type.parse(type), posX, posY, null));
        }

        return blocks;
    }
}
