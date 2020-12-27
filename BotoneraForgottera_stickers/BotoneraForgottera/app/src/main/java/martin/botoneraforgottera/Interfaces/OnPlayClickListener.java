package martin.botoneraforgottera.Interfaces;

import martin.botoneraforgottera.Models.Audio;
import martin.botoneraforgottera.Models.Tag;

public interface OnPlayClickListener {

    void onPlayClickListener(Audio audio);

    void onShareClickListener(Audio audio);

    void onTagClickListener(Tag tag);
}

