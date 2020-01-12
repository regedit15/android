package com.example.saytheword.Services;

import com.example.saytheword.Models.Palabra;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UtilService {

	public static final int TIPO_LISTADO_INGLES_ESPANIOL = 1;
	public static final int TIPO_LISTADO_ESPANIOL_INGLES = 2;

	public List<Palabra> palabras;

	public UtilService() {
		palabras = getPalabras();
	}

	public List<Palabra> getPalabras() {
		return new ArrayList<Palabra>() {{

			add(new Palabra("Yelling", "Gritando", ""));

			add(new Palabra("Wide", "Amplio", ""));

			add(new Palabra("Whistle", "Silbar", ""));

			add(new Palabra("Whine", "Gimoteo", ""));

			add(new Palabra("Warm", "Calentar", ""));

			add(new Palabra("Vow", "Voto", ""));

			add(new Palabra("Vault", "Bóveda", ""));

			add(new Palabra("Urchin", "Pilluelo", ""));

			add(new Palabra("Untamed", "Salvaje", ""));

			add(new Palabra("Unaware", "Inconsciente", ""));

			add(new Palabra("Triumph", "Triunfo", ""));

			add(new Palabra("Top That", "Encima De Eso", ""));

			add(new Palabra("Tingles", "Hormigueo", ""));

			add(new Palabra("Tied", "Atado", ""));

			add(new Palabra("Stutter", "Tartamudear", ""));

			add(new Palabra("Stuck", "Atascado", ""));

			add(new Palabra("Stream", "Corriente", ""));

			add(new Palabra("Stairs", "Escalera", ""));

			add(new Palabra("Stain", "Manchar", ""));

			add(new Palabra("Stab", "Puñalada", ""));

			add(new Palabra("Sniff", "Oler", ""));

			add(new Palabra("Smother", "Ahogar", ""));

			add(new Palabra("Smooth", "Suave", ""));

			add(new Palabra("Slip", "Resbalón", ""));

			add(new Palabra("Sizzle", "Chisporrotear", ""));

			add(new Palabra("Shape", "Forma", ""));

			add(new Palabra("Shall", "Deberá", ""));

			add(new Palabra("Sentence", "Frase", ""));

			add(new Palabra("Scalawag", "Pícaro", ""));

			add(new Palabra("Rub", "Frotar", ""));

			add(new Palabra("Roam", "Vagar", ""));

			add(new Palabra("Rise", "Subir", ""));

			add(new Palabra("Ripped", "Rasgado", ""));

			add(new Palabra("Quake", "Terremoto", ""));

			add(new Palabra("Prior", "Anterior", ""));

			add(new Palabra("Prancing Around", "Dando Vueltas", ""));

			add(new Palabra("Post", "Post", ""));

			add(new Palabra("Plotting", "Graficado", ""));

			add(new Palabra("Pardon", "Perdón", ""));

			add(new Palabra("Pal", "Camarada", ""));

			add(new Palabra("Ought", "Debería", ""));

			add(new Palabra("Not Either", "Tampoco", ""));

			add(new Palabra("Mutiny", "Motín", ""));

			add(new Palabra("Mood", "Estado Animico", ""));

			add(new Palabra("Mockery", "Burlas", ""));

			add(new Palabra("Messing", "Fastidiar", ""));

			add(new Palabra("Meant", "Significaba", ""));

			add(new Palabra("May Rub Off On Me", "Puede Contagiarme", ""));

			add(new Palabra("Masking Tape", "Cinta Adhesiva", ""));

			add(new Palabra("Marvelous", "Maravilloso", ""));

			add(new Palabra("Manners", "Modales", ""));

			add(new Palabra("Make Way", "Ceder El Paso", ""));

			add(new Palabra("Lick", "Lamer", ""));

			add(new Palabra("Let's Get On", "Sigamos Adelante", ""));

			add(new Palabra("Lash", "Latigazo", ""));

			add(new Palabra("Kindness", "Amabilidad", ""));

			add(new Palabra("Highbrow", "Intelectual", ""));

			add(new Palabra("Heck", "Infierno", ""));

			add(new Palabra("Grab", "Agarrar", ""));

			add(new Palabra("Get Mean", "Ser Malo", ""));

			add(new Palabra("Gee", "Caramba", ""));

			add(new Palabra("Flip", "Dar La Vuelta", ""));

			add(new Palabra("Flaw", "Falla", ""));

			add(new Palabra("Fingernails", "Las Uñas", ""));

			add(new Palabra("Filth", "Inmundicia", ""));

			add(new Palabra("Faint", "Desmayarse", ""));

			add(new Palabra("Earn", "Ganar", ""));

			add(new Palabra("Dive", "Bucear", ""));

			add(new Palabra("Deserve", "Merecer", ""));

			add(new Palabra("Deceive", "Engañar", ""));

			add(new Palabra("Curse", "Maldición", ""));

			add(new Palabra("Curs", "Curs", ""));

			add(new Palabra("Crowd", "Multitud", ""));

			add(new Palabra("Coating", "Revestimiento", ""));

			add(new Palabra("Choir", "Coro", ""));

			add(new Palabra("Borrow", "Pedir Prestado", ""));

			add(new Palabra("Booing", "Abuchear", ""));

			add(new Palabra("Blissfully", "Felizmente", ""));

			add(new Palabra("Blathering", "Chillidos", ""));

			add(new Palabra("Birth", "Nacimiento", ""));

			add(new Palabra("Beverages", "Bebidas", ""));

			add(new Palabra("Beg", "Mendigar", ""));

			add(new Palabra("Attempt", "Intento", ""));

			add(new Palabra("At Least", "Al Menos", ""));

			add(new Palabra("Almonds", "Almendras", ""));

		}};
	}

	public Palabra getPalabraAleatoriaSinRepetir() {
		new Random().nextInt(palabras.size() - 1);

		return null;
	}
}
