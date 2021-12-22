package martin.botoneraforgottera.Interfaces;

import java.util.ArrayList;

import martin.botoneraforgottera.Sticker.StickerPack;

public interface StickerListener {

    void listarStickers(StickerPack stickerPack);

    void listarPaquetes(ArrayList<StickerPack> stickerPackList);
}

