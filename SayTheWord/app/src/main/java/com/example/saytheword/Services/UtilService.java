package com.example.saytheword.Services;

import com.example.saytheword.Models.VerboIrregular;
import com.example.saytheword.Models.Palabra;

import java.util.ArrayList;
import java.util.List;

public class UtilService {

	public static final String LISTADO_TIPO_TRADUCCION_INGLES_ESPANIOL = "LISTADO_TIPO_TRADUCCION_INGLES_ESPANIOL";
	public static final String LISTADO_TIPO_TRADUCCION_ESPANIOL_INGLES = "LISTADO_TIPO_TRADUCCION_ESPANIOL_INGLES";
	public static final String JUEGO_TIPO_TRADUCCION_INGLES_ESPANIOL = "JUEGO_TIPO_TRADUCCION_INGLES_ESPANIOL";
	public static final String JUEGO_TIPO_TRADUCCION_ESPANIOL_INGLES = "JUEGO_TIPO_TRADUCCION_ESPANIOL_INGLES";

	public static final String LISTADO_PALABRAS = "LISTADO_PALABRAS";
	public static final String LISTADO_PALABRAS_PROBLEMATCAS = "LISTADO_PALABRAS_PROBLEMATCAS";
	public static final String LISTADO_VERBOS_IRREGULARES = "LISTADO_VERBOS_IRREGULARES";
	public static final String LISTADO_VERBOS_IRREGULARES_PROBLEMATCOS = "LISTADO_VERBOS_IRREGULARES_PROBLEMATCOS";

	public static final String JUEGO_PALABRAS = "JUEGO_PALABRAS";
	public static final String JUEGO_PALABRAS_PROBLEMATICAS = "JUEGO_PALABRAS_PROBLEMATICAS";
	public static final String JUEGO_VERBOS_IRREGULARES = "JUEGO_VERBOS_IRREGULARES";
	public static final String JUEGO_VERBOS_IRREGULARES_PROBLEMATICOS = "JUEGO_VERBOS_IRREGULARES_PROBLEMATICOS";

	public RealmService realmService = new RealmService();

	public UtilService() {
	}

	public List<Palabra> getPalabras(boolean soloPalabrasProblematicas) {

		List<Palabra> palabras = realmService.getPalabras();

		if (palabras.isEmpty()) {
			palabras = new ArrayList<Palabra>() {{
				add(new Palabra("Almonds", "Almendras", "Almonds"));
				add(new Palabra("At Least", "Al Menos", "At List"));
				add(new Palabra("Attempt", "Intento", "Attempt"));
				add(new Palabra("Beg", "Mendigar", "Beg"));
				add(new Palabra("Beverages", "Bebidas", "Béverages"));
				add(new Palabra("Birth", "Nacimiento", "Birz"));
				add(new Palabra("Blathering", "Chillidos", "Bladering"));
				add(new Palabra("Blissfully", "Felizmente", "Blissfully"));
				add(new Palabra("Booing", "Abuchear", "Buing"));
				add(new Palabra("Borrow", "Pedir Prestado", "Barrow"));
				add(new Palabra("Choir", "Coro", "Cuaier"));
				add(new Palabra("Coating", "Revestimiento", "Coting"));
				add(new Palabra("Crowd", "Multitud", "Crawd"));
				add(new Palabra("Curs", "Canalla", "Kurs"));
				add(new Palabra("Curse", "Maldición", "Curs"));
				add(new Palabra("Deceive", "Engañar", "Diciv"));
				add(new Palabra("Deserve", "Merecer", "Diserve"));
				add(new Palabra("Dive", "Bucear", "Daive"));
				add(new Palabra("Earn", "Ganar", "Earn"));
				add(new Palabra("Faint", "Desmayarse", "Feint"));
				add(new Palabra("Filth", "Inmundicia", "Filf"));
				add(new Palabra("Fingernails", "Las Uñas", "Fingernails"));
				add(new Palabra("Flaw", "Falla", "Floa"));
				add(new Palabra("Flip", "Dar La Vuelta", "Flep"));
				add(new Palabra("Gee", "Caramba", "Gii"));
				add(new Palabra("Get Mean", "Ser Malo", "Get Min"));
				add(new Palabra("Grab", "Agarrar", "Grab"));
				add(new Palabra("Heck", "Infierno", "Jak"));
				add(new Palabra("Highbrow", "Intelectual", "Highbrow"));
				add(new Palabra("Kindness", "Amabilidad", "Kaindnes"));
				add(new Palabra("Lash", "Latigazo", "Lash"));
				add(new Palabra("Let's Get On", "Sigamos Adelante", "Let's Get On"));
				add(new Palabra("Lick", "Lamer", "Leck"));
				add(new Palabra("Make Way", "Ceder El Paso", "Make Wey"));
				add(new Palabra("Manners", "Modales", "Menners"));
				add(new Palabra("Marvelous", "Maravilloso", "Marvelous"));
				add(new Palabra("Masking Tape", "Cinta Adhesiva", "Masking Tape"));
				add(new Palabra("May Rub Off On Me", "Puede Contagiarme", "Mey Rub Off On Me"));
				add(new Palabra("Meant", "Significaba", "Ment"));
				add(new Palabra("Messing", "Fastidiar", "Messing"));
				add(new Palabra("Mockery", "Burlas", "Mackery"));
				add(new Palabra("Mood", "Estado Animico", "Muud"));
				add(new Palabra("Mutiny", "Motín", "Miutiny"));
				add(new Palabra("Not Either", "Tampoco", "Nat Ither"));
				add(new Palabra("Ought", "Debería", "Óot"));
				add(new Palabra("Pal", "Camarada", "Pel"));
				add(new Palabra("Pardon", "Perdón", "Pardn"));
				add(new Palabra("Plotting", "Graficado", "Plotting"));
				add(new Palabra("Post", "Poste", "Poust"));
				add(new Palabra("Prancing Around", "Dando Vueltas", "Prancing Around"));
				add(new Palabra("Prior", "Anterior", "Praior"));
				add(new Palabra("Quake", "Terremoto", "Queike"));
				add(new Palabra("Ripped", "Rasgado", "Reept"));
				add(new Palabra("Rise", "Subir", "Raise"));
				add(new Palabra("Roam", "Vagar", "Roum"));
				add(new Palabra("Rub", "Frotar", "Rab"));
				add(new Palabra("Scalawag", "Pícaro", "Scalawag"));
				add(new Palabra("Sentence", "Frase", "Sentence"));
				add(new Palabra("Shall", "Deberá", "Shall"));
				add(new Palabra("Shape", "Forma", "Sheip"));
				add(new Palabra("Sizzle", "Chisporrotear", "Sizzel"));
				add(new Palabra("Slip", "Resbalón", "Slip"));
				add(new Palabra("Smooth", "Suave", "Smuuth"));
				add(new Palabra("Smother", "Ahogar", "Smather"));
				add(new Palabra("Sniff", "Oler", "Sniff"));
				add(new Palabra("Stab", "Puñalada", "Staab"));
				add(new Palabra("Stain", "Manchar", "Stein"));
				add(new Palabra("Stairs", "Escalera", "Steirs"));
				add(new Palabra("Stream", "Corriente", "Striam"));
				add(new Palabra("Stuck", "Atascado", "Stack"));
				add(new Palabra("Stutter", "Tartamudear", "Stadder"));
				add(new Palabra("Tied", "Atado", "Taid"));
				add(new Palabra("Tingles", "Hormigueo", "Tingls"));
				add(new Palabra("Top That", "Encima De Eso", "Top Dat"));
				add(new Palabra("Triumph", "Triunfo", "Traiamph"));
				add(new Palabra("Unaware", "Inconsciente", "Anaware"));
				add(new Palabra("Untamed", "Salvaje", "Antamd"));
				add(new Palabra("Urchin", "Pilluelo", "Urchin"));
				add(new Palabra("Vault", "Bóveda", "Voolt"));
				add(new Palabra("Vow", "Voto", "Vau"));
				add(new Palabra("Warm", "Calentar", "Worm"));
				add(new Palabra("Whine", "Gimoteo", "Waine"));
				add(new Palabra("Whistle", "Silbar", "Whisel"));
				add(new Palabra("Wide", "Amplio", "Waid"));
				add(new Palabra("Yelling", "Gritando", "Ielling"));
			}};

			realmService.insertarPalabras(palabras);
		}

		if (soloPalabrasProblematicas) {
			palabras = realmService.getPalabrasProblematicas();
		}

		return palabras;
	}

	public List<VerboIrregular> getVerbosIrregulares(boolean soloPalabrasProblematicas) {

		List<VerboIrregular> palabras = realmService.getIrregularVerbs();

		if (palabras.isEmpty()) {
			palabras = new ArrayList<VerboIrregular>() {{
				add(new VerboIrregular("Be", "Bi", "Ser/estar", "Was/Were", "Was/were", "Been", "Biin"));
				add(new VerboIrregular("Beat", "Bit", "Golpear", "Beat", "Bit", "Beaten", "Biten"));
				add(new VerboIrregular("Become", "Bicome", "Convertirse", "Became", "Biqueim", "Become", "Bicom"));
				add(new VerboIrregular("Begin", "Bigen", "Comenzar, Empezar", "Began", "Bigan", "Begun", "Bigon"));
			}};

			realmService.insertarIrregularVerbs(palabras);
		}

		if (soloPalabrasProblematicas) {
			palabras = realmService.getIrregularVerbsProblematicos();
		}

		return palabras;
	}

}
