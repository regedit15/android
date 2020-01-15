package com.example.saytheword.Services;

import com.example.saytheword.Models.Palabra;
import com.example.saytheword.Models.VerboIrregular;

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
				add(new VerboIrregular("Be", "Bi", "Ser, estar", "Was/Were", "Was/were", "Been", "Biin"));
				add(new VerboIrregular("Beat", "Bit", "Golpear", "Beat", "Bit", "Beaten", "Biten"));
				add(new VerboIrregular("Become", "Bicome", "Convertirse", "Became", "Biqueim", "Become", "Bicom"));
				add(new VerboIrregular("Begin", "Bigen", "Comenzar, empezar", "Began", "Bigan", "Begun", "Bigon"));
				add(new VerboIrregular("Bend", "Bend", "Doblar, inclinarse", "Bent", "Bent", "Bent", "Bent"));
				add(new VerboIrregular("Bite", "Bait", "Morder, picar", "Bit", "Bit", "Bit", "Bit"));
				add(new VerboIrregular("Blow", "Blow", "Soplar", "Blew", "Bluu", "Blown ", "Blown "));
				add(new VerboIrregular("Break", "Breik", "Romper, recreo, faltar a", "Broke", "Brouk", "Broken", "Brouken"));
				add(new VerboIrregular("Bring", "Bring", "Traer, llevar", "Brought", "Broot", "Brought ", "Broot"));
				add(new VerboIrregular("Build", "Bild", "Construir", "Built ", "Bilt", "Built", "Built"));
				add(new VerboIrregular("Burn", "Bern", "Quemar", "Burnt/Burned", "Bernt", "Burnt/Burned", "Bernt"));
				add(new VerboIrregular("Burst", "Burst", "Reventar, surgir", "Burst", "Burst", "Burst", "Burst"));
				add(new VerboIrregular("Buy", "Bay", "Comprar", "Bought", "Boot", "Bought", "Boot"));
				add(new VerboIrregular("Catch", "Catch", "Atrapar", "Caught", "Coot", "Caught", "Coot"));
				add(new VerboIrregular("Choos", "Chuus", "Atrapar", "Chose", "Chouse", "Chosen", "Chousen"));
				add(new VerboIrregular("Come", "Cam", "Venir, llegart", "Came", "Keim", "Come", "Cam"));
				add(new VerboIrregular("Cost", "Cost", "Costar, precio", "Cost", "Cost", "Cost", "Cost"));
				add(new VerboIrregular("Cut", "Cot", "Cortar", "Cut", "Cot", "Cut", "Cot"));
				add(new VerboIrregular("Deal", "Diel", "Tratar, negociar, reparto", "Dealt", "Delt", "Dealt", "Delt"));
				add(new VerboIrregular("Dig", "Dig", "Cabar", "Dug", "Dog", "Dug", "Dog"));
				add(new VerboIrregular("Do", "Do", "Hacer", "Did", "Did", "Done", "Don"));
				add(new VerboIrregular("Draw", "Dra", "Dibujar, sacar, extraer, empate, sacar", "Drew", "Druu", "Drawn", "Drawn"));
				add(new VerboIrregular("Dream", "Drim", "Soñar", "Dreamt/Dreamed", "Dramt/Drim", "Dreamt/Dreamed", "Dramt/Drim"));
				add(new VerboIrregular("Drink", "Drink", "Beber", "Drank", "Drank", "Drunk", "Dronk"));
				add(new VerboIrregular("Drive", "Draiv", "Conducir", "Drove", "Drouv", "Driven", "driven"));
				add(new VerboIrregular("Eat", "Iit", "Comer", "Ate", "Eit", "Eaten", "Itn"));
				add(new VerboIrregular("Fall", "Fool", "Caer", "Fell", "Fell", "Fallen", "Follen"));
				add(new VerboIrregular("Feed", "Fiid", "Alimentar", "Fed", "Fed", "Fed", "Fed"));
				add(new VerboIrregular("Feel", "Fiil", "Sentir, tocar", "Felt", "Felt", "Felt", "Felt"));
				add(new VerboIrregular("Fight", "Faight", "Sentir, tocar", "Fought", "Foot", "Fought", "Foot"));
				add(new VerboIrregular("Find", "Faind", "Hallar, encontrar", "Found", "faund", "Found", "Found"));
				add(new VerboIrregular("Fly", "Flay", "Volar", "Flew", "Fluu", "Flow", "Flouw"));
				add(new VerboIrregular("Forbid", "Forbid", "Prohibir", "Forbade", "Forbeid", "Dorbidden", "Dorbiddn"));
				add(new VerboIrregular("Forgive", "Forgiv", "Perdonar", "Forgave", "Forgeiv", "Forgiven", "Forgiven"));
				add(new VerboIrregular("Freeze", "Friiz", "Congelar", "Froze", "Fouz", "Frozen", "Fouzen"));
				add(new VerboIrregular("Get", "Get", "Obtener, llegar a, ponerse", "Got", "Gat/Got", "Got", "Gat/Got"));
				add(new VerboIrregular("Give", "Giv", "Dar, otorgar, entregar", "Gave", "Geiv", "Given", "Given"));
				add(new VerboIrregular("Go", "Gou", "Ir, vamos", "Went", "Went", "Gone", "Gon"));
				add(new VerboIrregular("Grow", "Grow", "Crecer", "Grew", "Gruu", "Grown", "Grown"));
				add(new VerboIrregular("Hang", "Hang", "Colgar", "Hung", "Hung/Hang", "Hung", "Hung/Hang"));
				add(new VerboIrregular("Have", "Hav", "Tener, haber", "Had", "Had", "Had", "Had"));
				add(new VerboIrregular("Hear", "Hir", "Escuchar, oir", "Heard", "Herd", "Heard", "Herd"));
				add(new VerboIrregular("Hide", "Haid", "Esconder, ocultar", "Hid", "Hid", "Hidden", "Hiddn"));
				add(new VerboIrregular("Hit", "Hit", "Golpear, pegar", "Hit", "Hit", "Hit", "Hit"));
				add(new VerboIrregular("Hold", "Hold", "Sostener, agarrar", "Held", "Held", "Held", "Held"));
				add(new VerboIrregular("Hurt", "Hurt/Hert", "Herir, lastimar", "Hurt", "Hurt/Hert", "Hurt", "Hurt/Hert"));
				add(new VerboIrregular("Keep", "Kiip", "Conservar, quedarse, guardar, lastimar", "Kept", "Kept", "Kept", "Kept"));
				add(new VerboIrregular("Know", "Now", "Saber, conocer", "Knew", "Niu", "Known", "Known"));
				add(new VerboIrregular("Lay", "Ley", "Poner, colocar, tenderse, hechar", "Laid", "Leid", "Laid", "Leid"));
				add(new VerboIrregular("Lead", "Liid", "Conducir, llevar, dirigir", "Led", "Led", "Led", "Led"));
				add(new VerboIrregular("Learn", "Lern", "Leer", "Lernt/Lerned", "Lernt/Lernd", "Lernt/Lerned", "Lernt/Lernd"));
				add(new VerboIrregular("Leave", "Liiv", "Dejar", "Left", "Left", "Left", "Left"));
				add(new VerboIrregular("Let", "Let", "Permitir", "Let", "Let", "Let", "Let"));
				add(new VerboIrregular("Lie", "Lai", "Mentir, hecharse, acostarse", "Lay", "Ley", "Lain", "Lein"));
				add(new VerboIrregular("Light", "Laight", "Encender, prender", "Lit", "Lit", "Lit", "Lit"));
				add(new VerboIrregular("Lose", "Luuz", "Perder", "Lost", "Lost", "Lost", "Lost"));
				add(new VerboIrregular("Make", "Meike", "Hacer", "Made", "Meid", "Made", "Meid"));
				add(new VerboIrregular("Mean", "Miin", "Significar", "Meant", "Ment", "Meant", "Ment"));
				add(new VerboIrregular("Meet", "Miit", "Encontrar, conocer", "Met", "Met", "Met", "Met"));
				add(new VerboIrregular("Pay", "Pey", "Pagar, abonar, rendir", "Paid", "Peid", "Paid", "Peid"));
				add(new VerboIrregular("Put", "Put", "Poner", "Put", "Put", "Put", "Put"));
				add(new VerboIrregular("Read", "Riid", "Leer", "Read", "Riid", "Read", "Riid"));
				add(new VerboIrregular("Ride", "Raide", "Montar, andar", "Rode", "Roud", "Ridden", "Riddn"));
				add(new VerboIrregular("Ring", "Raide", "Llamar, sonar", "Rang", "Reng", "Rung", "Rang"));
				add(new VerboIrregular("Rise", "Raise", "Subir, crecer, levantarse", "Rose", "Rous", "Risen", "Risen"));
				add(new VerboIrregular("Run", "Ran", "Correr", "Ran", "Ran", "Run", "Ran"));
				add(new VerboIrregular("Say", "Sey", "Decir", "Said", "Sed", "Said", "Sed"));
				add(new VerboIrregular("See", "Sii", "Ver", "Saw", "Soo", "Seen", "Siin"));
				add(new VerboIrregular("See", "Sii", "Ver", "Saw", "Soo", "Seen", "Siin"));
				add(new VerboIrregular("Sell", "Sell", "Vender", "Sold", "Sold", "Sold", "Sold"));
				add(new VerboIrregular("Send", "Send", "Mandar, enviar", "Sent", "Sent", "Sent", "Sent"));
				add(new VerboIrregular("Set", "Send", "Poner, establecer, fijar", "Set", "Set", "Set", "Set"));
				add(new VerboIrregular("Shake", "Sheik", "Sacudir", "Shook", "Shuuk", "Shaken", "Sheiken"));
				add(new VerboIrregular("Shine", "Shain", "Brillar", "Shone", "Shon", "Shone", "Shone"));
				add(new VerboIrregular("Shoot", "Shuut", "Disparar", "Shot", "Shot/Shat", "Shot", "Shot/Shat"));
				add(new VerboIrregular("Shoot", "Shuut", "Disparar", "Shot", "Shot/Shat", "Shot", "Shot/Shat"));
				add(new VerboIrregular("Show", "Show", "Mostrar", "Showed", "Showd", "Shown", "Shown"));
				add(new VerboIrregular("Shut", "Shat", "Cerrar", "Shut", "Shat", "Shut", "Shat"));
				add(new VerboIrregular("Sing", "Sing", "Cantar", "Sang/seng", "Shat", "Sung", "Song"));
				add(new VerboIrregular("Sink", "Sink", "Hundir, descender", "Sank", "Saenk", "Sunk", "Sank"));
				add(new VerboIrregular("Sit", "Sit", "Sentarse", "Sat", "Sat", "Sat", "Sat"));
				add(new VerboIrregular("Sleep", "Sliip", "Dormir", "Slept", "Slept", "Slept", "Slept"));
				add(new VerboIrregular("Speak", "Spik", "Hablar", "Spoke", "Spouk", "Spoken", "Spouken"));
				add(new VerboIrregular("Spell", "Spell", "Deletrear", "Spelt/Spelled", "Spelt/Spelled", "Spelt/Spelled", "Spelt/Spelled"));
				add(new VerboIrregular("Spend", "Spend", "Gastar, agotar", "Spent", "Spent", "Spent", "Spent"));
				add(new VerboIrregular("Stand", "Stand", "Estar en pie, sostener", "Stood", "Stuud", "Stood", "Stuud"));
				add(new VerboIrregular("Steal", "Steal", "Robar", "Stol/Stoul", "Stol", "Stolen", "Stolen"));
				add(new VerboIrregular("Stick", "Stick/Steck", "Pegar, adherir", "Stuck", "Stock", "Stuck", "Stock"));
				add(new VerboIrregular("Swim", "Swim", "Nadar", "Swam", "Swaem", "Swum", "Swam"));
				add(new VerboIrregular("Take", "Teik", "Tomar", "Took", "Tuuk", "Taken", "Teiken"));
				add(new VerboIrregular("Teach", "Tich", "Enseñar", "Taught", "Toot", "Taught", "Toot"));
				add(new VerboIrregular("Tear", "Tier", "Rasgar, arrancar", "Tore", "Toor", "Torn", "Torn"));
				add(new VerboIrregular("Tell", "Tell", "Decir", "Told", "Told", "Told", "Told"));
				add(new VerboIrregular("Think", "Think", "Pensar", "Thought", "Zoot", "Thought", "Zoot"));
				add(new VerboIrregular("Throw", "Throw", "Arrojar, tirar, lanzar", "Threw", "Thruu", "Thrown", "Thrown"));
				add(new VerboIrregular("Understand", "Anderstand", "Entender, comprender", "Understood", "Anderstuud", "Understood", "Anderstuud"));
				add(new VerboIrregular("Wake", "Weik", "Despertar", "Woke", "Wouk", "Woken", "Wouken"));
				add(new VerboIrregular("Wake", "Weik", "Despertar", "Woke", "Wouk", "Woken", "Wouken"));
				add(new VerboIrregular("Wear", "Wear/Wea", "Usar, llevar puesto", "Wore", "Wuor/Wúo", "Worn", "Worn"));
				add(new VerboIrregular("Win", "Win", "Ganar", "Won", "Wan", "Won", "Wan"));
				add(new VerboIrregular("Write", "Write", "Escribir", "Wrote", "Wrout", "Written", "Writtn"));
			}};

			realmService.insertarIrregularVerbs(palabras);
		}

		if (soloPalabrasProblematicas) {
			palabras = realmService.getIrregularVerbsProblematicos();
		}

		return palabras;
	}

}
