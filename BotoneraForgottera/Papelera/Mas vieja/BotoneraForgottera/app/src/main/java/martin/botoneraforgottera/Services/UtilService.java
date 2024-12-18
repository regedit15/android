package martin.botoneraforgottera.Services;

import java.util.ArrayList;
import java.util.List;

import martin.botoneraforgottera.Models.Audio;
import martin.botoneraforgottera.Models.Tag;
import martin.botoneraforgottera.R;

public class UtilService {

	public List<Audio> getAudios() {
		return new ArrayList<Audio>() {{
			add(new Audio(R.raw.uber1, "Te voy a tocar la jalea", "Descripción 1", new ArrayList<Tag>() {{
				add(new Tag("uber"));
				add(new Tag("jalea"));
			}}));
			add(new Audio(R.raw.luacha1, "Luacha 1", "Descripción 22", new ArrayList<Tag>() {{
				add(new Tag("luacha"));
				add(new Tag("grito"));
			}}));
		}};
	}
}
