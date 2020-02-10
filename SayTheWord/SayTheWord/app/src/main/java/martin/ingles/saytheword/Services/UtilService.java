package martin.ingles.saytheword.Services;

import android.app.Activity;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import martin.ingles.saytheword.Models.Palabra;
import martin.ingles.saytheword.Models.VerboIrregular;

public class UtilService {

	public static final String LISTADO_TIPO_TRADUCCION_INGLES_ESPANIOL = "LISTADO_TIPO_TRADUCCION_INGLES_ESPANIOL";
	public static final String LISTADO_TIPO_TRADUCCION_ESPANIOL_INGLES = "LISTADO_TIPO_TRADUCCION_ESPANIOL_INGLES";
	public static final String JUEGO_TIPO_TRADUCCION_INGLES_ESPANIOL = "JUEGO_TIPO_TRADUCCION_INGLES_ESPANIOL";
	public static final String JUEGO_TIPO_TRADUCCION_ESPANIOL_INGLES = "JUEGO_TIPO_TRADUCCION_ESPANIOL_INGLES";

	public static final String LISTADO_PALABRAS = "LISTADO_PALABRAS";
	public static final String LISTADO_VERBOS_IRREGULARES = "LISTADO_VERBOS_IRREGULARES";

	public static final int ESTADO_FACIL = 1;
	public static final int ESTADO_NORMAL = 2;
	public static final int ESTADO_DIFICIL = 3;

	public RealmService realmService = new RealmService();

	public SharedPreferenceService sharedPreferenceService;
	protected static final String PREFERENCES = "PREFERENCES";
	protected static final String DATOD_GUARDADOS = "DATOD_GUARDADOS";

	public UtilService() {
	}

	public void setsharedPreferenceService(Activity activity) {
		sharedPreferenceService = new SharedPreferenceService(activity.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE));
	}

	public boolean conteinsIgnoreCase(String palabraBuscada, String frase) {
		return frase.toLowerCase().contains(frase.toLowerCase());
	}

	public ArrayList<Palabra> getPalabrasEstaticas() {
		return new ArrayList<Palabra>() {{
			//--------------- 1 Parte
			add(new Palabra("Almonds", "Almendras", "Almonds"));
			add(new Palabra("At least", "Al menos", "At list"));
			add(new Palabra("Attempt", "Intento", "Attempt"));
			add(new Palabra("Beg", "Mendigar", "Beg"));
			add(new Palabra("Beverages", "Bebidas", "Béverages"));
			add(new Palabra("Birth", "Nacimiento", "Birz"));
			add(new Palabra("Blathering", "Chillidos", "Bladering"));
			add(new Palabra("Blissfully", "Felizmente", "Blissfully"));
			add(new Palabra("Booing", "Abuchear", "Buing"));
			add(new Palabra("Borrow", "Pedir prestado", "Barrow"));
			add(new Palabra("Choir", "Coro", "Cuaier"));
			add(new Palabra("Coating", "Revestimiento", "Coting"));
			add(new Palabra("Crowd", "Multitud", "Crawd"));
			add(new Palabra("Curs", "Canalla", "Kurs"));
			add(new Palabra("Curse", "Maldición", "Curs"));
			add(new Palabra("Deceive", "Engañar", "Diciv"));
			add(new Palabra("Deserve", "Merecer", "Diserv"));
			add(new Palabra("Dive", "Bucear", "Daive"));
			add(new Palabra("Earn", "Ganar", "Earn"));
			add(new Palabra("Faint", "Desmayarse", "Feint"));
			add(new Palabra("Filth", "Inmundicia", "Filf"));
			add(new Palabra("Fingernails", "Uñas", "Fingernails"));
			add(new Palabra("Flaw", "Falla", "Floa"));
			add(new Palabra("Flip", "Dar la vuelta", "Flep"));
			add(new Palabra("Gee", "Caramba", "Gii"));
			add(new Palabra("Get mean", "Ser malo", "Get min"));
			add(new Palabra("Grab", "Agarrar", "Grab"));
			add(new Palabra("Heck", "Infierno", "Hack"));
			add(new Palabra("Highbrow", "Intelectual", "Highbrow"));
			add(new Palabra("Kindness", "Amabilidad", "Kaindnes"));
			add(new Palabra("Lash", "Latigazo", "Lash"));
			add(new Palabra("Let's get on", "Sigamos adelante", "Let's get on"));
			add(new Palabra("Lick", "Lamer", "Leck"));
			add(new Palabra("Make way", "Ceder el paso", "Meike wey"));
			add(new Palabra("Manners", "Modales", "Menners"));
			add(new Palabra("Marvelous", "Maravilloso", "Marvelous"));
			add(new Palabra("Masking tape", "Cinta adhesiva", "Masking tape"));
			add(new Palabra("May rub off on me", "Puede contagiarme", "Mey rob off on me"));
			add(new Palabra("Mean", "Significar, suponer, promedio, media", "Min"));
			add(new Palabra("Messing", "Fastidiar", "Messing"));
			add(new Palabra("Mockery", "Burlas", "Mackery"));
			add(new Palabra("Mood", "Estado anímico, humor", "Muud"));
			add(new Palabra("Mutiny", "Motín", "Miutiny"));
			add(new Palabra("Not either", "Tampoco", "Nat ither"));
			add(new Palabra("Ought", "Debería", "Óot"));
			add(new Palabra("Pal", "Camarada", "Pel"));
			add(new Palabra("Pardon", "Perdón", "Pardn"));
			add(new Palabra("Plotting", "Graficado", "Plotting"));
			add(new Palabra("Post", "Poste", "Poust"));
			add(new Palabra("Prancing around", "Dando vueltas", "Prancing around"));
			add(new Palabra("Prior", "Anterior", "Praior"));
			add(new Palabra("Quake", "Terremoto", "Queike"));
			add(new Palabra("Ripped", "Rasgado", "Rept"));
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
			add(new Palabra("Stair", "Escalera", "Steir"));
			add(new Palabra("Stream", "Corriente", "Strim"));
			add(new Palabra("Stuck", "Atascado", "Stack"));
			add(new Palabra("Stutter", "Tartamudear", "Stadder"));
			add(new Palabra("Tied", "Atado", "Taid"));
			add(new Palabra("Tingles", "Hormigueo", "Tingls"));
			add(new Palabra("Top that", "Encima de eso", "Top dat"));
			add(new Palabra("Triumph", "Triunfo", "Traiamph"));
			add(new Palabra("Unaware", "Inconsciente", "Anawer"));
			add(new Palabra("Untamed", "Salvaje", "Antamd"));
			add(new Palabra("Urchin", "Pilluelo", "Urchin"));
			add(new Palabra("Vault", "Bóveda", "Voolt"));
			add(new Palabra("Vow", "Voto", "Vau"));
			add(new Palabra("Warm", "Calentar", "Worm"));
			add(new Palabra("Whine", "Gimoteo", "Waine"));
			add(new Palabra("Whistle", "Silbar", "Whisel"));
			add(new Palabra("Wide", "Amplio", "Waid"));
			add(new Palabra("Yell", "Gritar", "Iell"));
			//--------------- 2 Parte
			add(new Palabra("Tight", "Apretado", "Taight"));
			add(new Palabra("Hardly", "Apenas", "Hardly"));
			add(new Palabra("Meager", "Pobre, escaso", "Miger"));
			add(new Palabra("Owe", "Deber", "Óuu"));
			add(new Palabra("Cheapskate", "Tacaño", "Chipskeit"));
			add(new Palabra("Fairly", "Bastante", "Ferly"));
			add(new Palabra("Heap", "Montón", "Hip"));
			add(new Palabra("Fence", "Cerca, vaya", "Fens"));
			add(new Palabra("Unfair", "Injusto", "Anfeir"));
			add(new Palabra("Greed", "Codicia", "Griid"));
			add(new Palabra("Let's go get", "Vamos a buscar", "Let's gou get"));
			add(new Palabra("Fate", "Destino", "Feit"));
			add(new Palabra("Pick on", "Elegir, meterse con, molestar", "Pick on"));
			add(new Palabra("Pick", "Recoger", "Pick"));
			add(new Palabra("Bet", "Apuesta", "Bet"));
			add(new Palabra("Drop by", "Entrar un momento", "Drop bay"));
			add(new Palabra("Wreck", "Ruina", "Reck"));
			add(new Palabra("Hire", "Contratar, alquiler", "Haier"));
			add(new Palabra("Tip", "Propina", "Tip"));
			add(new Palabra("Rightful", "Legítimo", "Raightfol"));
			add(new Palabra("Gnaw", "Roer", "Gno"));
			add(new Palabra("Ankle", "Tobillo", "Anko"));
			add(new Palabra("Trip", "Viaje", "Trip"));
			add(new Palabra("Moat", "Foso", "Mout"));
			add(new Palabra("Rather", "Más bien, bastante", "Rather"));
			add(new Palabra("I'd rather", "Preferiría", "I'd rather"));
			add(new Palabra("Spineless", "Sin carácter", "Spainless"));
			add(new Palabra("Varmint", "Bribón", "Varment"));
			add(new Palabra("Rascal", "Bribón, pillo", "Rascol"));
			add(new Palabra("Wrangle", "Disputar, reñir", "Wrangl"));
			add(new Palabra("Belly", "Barriga", "Belly"));
			add(new Palabra("Tough", "Difícil, duro", "Tof"));
			add(new Palabra("Handle", "Encargarse de, manipular", "Handl"));
			add(new Palabra("Ornery", "Desagradable, vulgar", "Ornery"));
			add(new Palabra("Stew", "Estofado, guiso", "Stiu"));
			add(new Palabra("Tongue", "Lengua", "Tong"));
			add(new Palabra("Necklace", "Collar", "Neckles"));
			add(new Palabra("Silly", "Tonto, bobo", "Silly"));
			add(new Palabra("Shield", "Proteger, escudo, blindaje", "Shield"));
			add(new Palabra("Forehead", "Frente", "Forhead"));
			add(new Palabra("Theft", "Robo", "Zeft"));
			add(new Palabra("Mistook", "Confundir", "Mistuuk"));
			add(new Palabra("Threat", "Amenaza", "Thret"));
			add(new Palabra("Shrimp", "Camarón", "Shrimp"));
			add(new Palabra("Grub", "Comida", "Grob"));
			add(new Palabra("Somehow", "De alguna manera", "Somhaw"));
			add(new Palabra("Gather", "Reunir, acumular", "Gather"));
			add(new Palabra("Above", "Encima, arriba", "Ovob"));
			add(new Palabra("Boil", "Hervir", "Boil"));
			add(new Palabra("By chance", "Por casualidad", "Bay chanz"));
			add(new Palabra("Wealth", "Riqueza", "Welf"));
			add(new Palabra("Wonder", "Preguntarse, quien sabe", "Wuonder"));
			add(new Palabra("Foreign", "Exterior, extranjero", "Foreign"));
			add(new Palabra("Improve", "Mejorar, perfeccionar", "Impruv"));
			add(new Palabra("Allowance", "Tolerancia, pensión", "Allawens"));
			add(new Palabra("Soil", "Suelo, tierra", "Soiol"));
			add(new Palabra("Crawl", "Gatear", "Crol"));
			add(new Palabra("Stink", "Hedor, maloliente", "Stink"));
			add(new Palabra("Leak", "Fuga, escape, perdida", "Liik"));
			add(new Palabra("Screech", "Chillido", "Scriich"));
			add(new Palabra("Twisted", "Retorcido, doblado", "Twisted"));
			add(new Palabra("Fiend", "Demonio", "Find"));
			add(new Palabra("Worth it", "Vale la pena", "Worth it"));
			add(new Palabra("Tan", "Bronceado", "Tan"));
			add(new Palabra("Swear", "Jurar", "Swer"));
			add(new Palabra("Scratch", "Rasguño, arañar, rascar", "Scratch"));
			add(new Palabra("Gnarly", "Retorcido", "Narly"));
			add(new Palabra("Point out", "Señalar", "Point aut"));
			add(new Palabra("Stuff", "Cosas", "Staff"));
			add(new Palabra("Show Off", "Presumir", "Show Off"));
			add(new Palabra("Misshapen", "Deforme", "Missheipen"));
			add(new Palabra("Strike", "Golpear, ataque, huelga", "Straik"));
			add(new Palabra("Darn", "Maldito", "Darn"));
			add(new Palabra("Lagoon", "Laguna", "Laguun"));
			add(new Palabra("Plenty", "Mucho, muy", "Plenty"));
			add(new Palabra("Cramp", "Calambre", "Cramp"));
			add(new Palabra("Tread", "Huella, pisada", "Tred"));
			add(new Palabra("Drown", "Ahogar", "Drawn"));
			//-----------------------
			add(new Palabra("Fellows", "Becarios", "Fellows"));
			add(new Palabra("Stealth", "Sigilo, cautela", "Stealf"));
			add(new Palabra("Instead", "En lugar", "Insted"));
			add(new Palabra("Bless", "Bendecir, santificar", "Bless"));
			add(new Palabra("Groceries", "Comestibles", "Groceries"));
			add(new Palabra("Doubt", "Duda", "Daut"));
			//-----------------------
			add(new Palabra("Restless", "Inquieto", "Restless"));
			add(new Palabra("Trunk", "Tronco, maletero, baul", "Tronk"));
			add(new Palabra("Quite", "Bastante", "Kwait"));
			add(new Palabra("What does it take", "Qué se necesita", "What dos it taik"));
			add(new Palabra("Moron", "Idiota, imbecil", "Moran"));
			add(new Palabra("Fit in", "Encajar", "Fit in"));
			add(new Palabra("Wit", "Ingenio", "Wit"));
			add(new Palabra("Nor", "Nor", "Ni"));
			add(new Palabra("Fill", "Llenar, ocupar", "Fill"));
			add(new Palabra("Bald", "Calvo", "Bold"));
			add(new Palabra("Wisdom", "Sabiduría, juicio", "Wisdem"));
			add(new Palabra("Advice", "Consejo", "Edvais"));
			add(new Palabra("Pant", "Pantalón, jadear", "Pant"));
			add(new Palabra("Shelter", "Abrigo, amparo", "Shelter"));
			add(new Palabra("Clam", "Almeja", "Clam"));
			add(new Palabra("Cause", "Causa, motivo, razón", "Kooz"));
			add(new Palabra("Praise", "Alabar, elogiar", "Preis"));
			add(new Palabra("Earlier", "Más temprano", "Erlier"));
			add(new Palabra("Toe", "Dedo del pie", "Tou"));
			add(new Palabra("Diaper", "Pañal", "Daiper"));
			add(new Palabra("Recipe", "Receta", "Récepi"));
			add(new Palabra("Due", "Debido", "Du"));
			add(new Palabra("Starv", "Morir de hambre", "Starv"));
			add(new Palabra("Stranded", "Varado", "Strended"));
			add(new Palabra("Hail", "Granizo", "Heil"));
			add(new Palabra("Survey", "Encuesta", "Survey"));
			add(new Palabra("Shed", "Cobertizo", "Shed"));
			add(new Palabra("Behavior", "Comportamiento", "Baiheivior"));
			add(new Palabra("Graceful", "Agraciado", "Greicefol"));
			add(new Palabra("Either", "Ya sea", "Ither"));
			add(new Palabra("High jinks", "Travesuras", "Haig jinks"));
			add(new Palabra("Haunt", "Obsesionar, embrujar", "Honted"));
			add(new Palabra("Burden", "Carga", "Berdn"));
			add(new Palabra("Faithful", "Fiel", "Feitfol"));
			add(new Palabra("Bellyache", "Dolor de vientre", "Bellyeik"));
			add(new Palabra("Give up", "Rendirse", "Giv ap"));
			add(new Palabra("Wild", "Salvaje", "Waild"));
			add(new Palabra("Whole", "Todo, entero", "Houl"));
			add(new Palabra("Skinny", "Flaco", "Skinny"));
			add(new Palabra("Thin", "Delgado", "Thin"));
			add(new Palabra("Hilarious", "Divertidísimo", "Hilerious"));
			add(new Palabra("Encourage", "Alentar, fomentar", "Incorreich"));
			add(new Palabra("Sludge", "Lodo", "Slodg"));
			add(new Palabra("Slither", "Deslizarse", "Slither"));
			add(new Palabra("Charm", "Encanto", "Charm"));
			add(new Palabra("Vaccine", "Vacuna", "Vakcin"));
			add(new Palabra("Spread", "Untado, propagado, difundir", "Spred"));
			add(new Palabra("Sneak", "Furtivo", "Snik"));
			add(new Palabra("Crisp", "Crujiente", "Crisp"));
			add(new Palabra("Gasp", "Jadear", "Gasp"));
			add(new Palabra("Sigh", "Suspirar", "Sai"));
			add(new Palabra("Matter", "Importar, asunto, cuestion", "Mader"));
			add(new Palabra("Thigh", "Muslo", "Thai"));
			add(new Palabra("Wail", "Gemido, lamento", "Weil"));
			add(new Palabra("Rear", "Posterior, parte trasera", "Rir"));
			add(new Palabra("I mean it", "Lo digo en serio", "I min it"));
			add(new Palabra("Afford", "Permitirse, proporsionar", "Afford"));
			add(new Palabra("Lean", "Apoyar, inclinar", "Liin"));
			add(new Palabra("Shavings", "Virutas", "Sheivings"));
			add(new Palabra("Rough", "Áspero, brusco", "Roff"));
			add(new Palabra("At stake", "En juego, en peligro", "At steik"));
			// ----------------
			add(new Palabra("Till", "Hasta", "Till"));
			add(new Palabra("Within", "Dentro", "Within"));
			add(new Palabra("Homie", "Amigo, colega", "Houmi"));
			add(new Palabra("Baseless", "Infundado", "Beisless"));
			add(new Palabra("Assumed", "Ficticio", "Assumd"));
			add(new Palabra("Perform", "Realizar, ejecutar", "Perform"));
			add(new Palabra("Straight", "Derecho, recto", "Streight"));
			add(new Palabra("Tickle", "Cosquillas", "Tickl"));
			add(new Palabra("Fellow", "Compañero, miembro", "Fellow"));
			add(new Palabra("Knowledge", "Conocimiento", "Nowledch"));
			add(new Palabra("Nasty", "Asqueroso", "Nasty"));
			add(new Palabra("Pour", "Verter, hechar", "Puur"));
			add(new Palabra("Handsome", "Hermoso, guapo", "Handsom"));
			add(new Palabra("Doom", "Condenar, perdicion", "Duum"));
			add(new Palabra("Tide", "Marea", "Taid"));
			add(new Palabra("Wrapp", "Envoltura", "Rapp"));
			add(new Palabra("Meal", "Comida", "Mieal"));
			add(new Palabra("Lookout", "Estar atento", "Lukaut"));
			add(new Palabra("Phony", "Falso, farsante", "Phouny"));
			add(new Palabra("Dupe", "Engañar", "Duup"));
			add(new Palabra("Clipping", "Recorte", "Clipping"));
			add(new Palabra("Choke", "Ahogo", "Chouk"));
			add(new Palabra("Relief", "Alivio", "Relif"));
			add(new Palabra("Not even", "Ni siquiera", "Nat iven"));
			add(new Palabra("Mop up", "Limpiar", "Mop ap"));
			add(new Palabra("Bury", "Enterrar, sepultar", "Berry"));
			add(new Palabra("Icky", "Asqueroso", "Icky"));
			add(new Palabra("Toss", "Sacudida", "Toss"));
			add(new Palabra("Ain't quite right", "No está del todo bien", "Ein't cuait raight"));
			add(new Palabra("Behalf", "Favor", "Bihaf"));
			add(new Palabra("Mudd", "Enlodado", "Modd"));
			add(new Palabra("Shovel", "Pala", "Shovl"));
			add(new Palabra("Lift", "Levantar", "Left"));
			add(new Palabra("Buckle up", "Cinturón de seguridad", "Backl ap"));
			add(new Palabra("Stow", "Estibar", "Stou"));
			add(new Palabra("Crew", "Personal, equipo, tripulacion", "Cruu"));
			add(new Palabra("Stitches", "Puntadas", "Stitches"));
			add(new Palabra("Stiff", "Rígido", "Stiff"));
			add(new Palabra("Deed", "Escritura, hecho", "Diid"));
			add(new Palabra("Stuffed", "Relleno", "Staffd"));
			add(new Palabra("Realize", "Realizar, darse cuenta de", "Rielaiz"));
			add(new Palabra("Brand", "Marca", "Brand"));
			add(new Palabra("Lizard", "Lagartija, lagarto", "Lizerd"));
			add(new Palabra("Chopper", "Helicóptero", "Chapper"));
			add(new Palabra("Perhaps", "Quizás", "Perhaps"));
			add(new Palabra("Stage", "Etapa, escenario", "Steich"));
			add(new Palabra("Such", "Tal", "Sach"));
			add(new Palabra("Wrestle", "Luchar", "Resel"));
			add(new Palabra("Suddenly", "Repentinamente, de repente", "Saddenly"));
			add(new Palabra("Lest", "Para que no", "Lest"));
			add(new Palabra("Strength", "Fuerza, resistencia", "Strengz"));
			add(new Palabra("Against", "En contra", "Agenst"));
			add(new Palabra("Lad", "Muchacho", "Lad"));
			add(new Palabra("Tights", "Pantymedias, mallas", "Tights"));
			add(new Palabra("Threaten", "Amenaza", "Thretn"));
			add(new Palabra("Waiter", "Camarero", "Weiter"));
			add(new Palabra("Belt", "Cinturón", "Belt"));
			add(new Palabra("Tiny", "Minúsculo, diminuto", "Tainy"));
			add(new Palabra("Wise", "Sabio, prudente", "Wais"));
			add(new Palabra("Height", "Altura", "Haight"));
			add(new Palabra("Jar", "Tarro", "Yar"));
			add(new Palabra("Shrink", "Encoger", "Shrink"));
		}};
	}

	public List<VerboIrregular> getVerbosIrregularesEstaticos() {
		return new ArrayList<VerboIrregular>() {{
			add(new VerboIrregular("Be", "Bi", "Ser, estar", "Was/Were", "Was/Were", "Been", "Biin"));
			add(new VerboIrregular("Beat", "Bit", "Golpear", "Beat", "Bit", "Beaten", "Biten"));
			add(new VerboIrregular("Become", "Bicom", "Convertirse", "Became", "Biqueim", "Become", "Bicom"));
			add(new VerboIrregular("Begin", "Bigen", "Comenzar, empezar", "Began", "Bigan", "Begun", "Bigon"));
			add(new VerboIrregular("Bend", "Bend", "Doblar, inclinarse", "Bent", "Bent", "Bent", "Bent"));
			add(new VerboIrregular("Bite", "Bait", "Morder, picar", "Bit", "Bit", "Bit", "Bit"));
			add(new VerboIrregular("Blow", "Blow", "Soplar, golpe", "Blew", "Bluu", "Blown", "Blown"));
			add(new VerboIrregular("Break", "Breik", "Romper, recreo, faltar a", "Broke", "Brouk", "Broken", "Brouken"));
			add(new VerboIrregular("Bring", "Bring", "Traer, llevar", "Brought", "Broot", "Brought", "Broot"));
			add(new VerboIrregular("Build", "Bild", "Construir", "Built", "Bilt", "Built", "Bilt"));
			add(new VerboIrregular("Burn", "Bern", "Quemar", "Burnt/Burned", "Bernt/Bernd", "Burnt/Burned", "Bernt/Bernd"));
			add(new VerboIrregular("Burst", "Burst", "Reventar, surgir", "Burst", "Burst", "Burst", "Burst"));
			add(new VerboIrregular("Buy", "Bay", "Comprar", "Bought", "Boot", "Bought", "Boot"));
			add(new VerboIrregular("Catch", "Catch", "Atrapar", "Caught", "Coot", "Caught", "Coot"));
			add(new VerboIrregular("Choos", "Chuus", "Atrapar", "Chose", "Chous", "Chosen", "Chousen"));
			add(new VerboIrregular("Come", "Cam", "Venir, llegar", "Came", "Keim", "Come", "Cam"));
			add(new VerboIrregular("Cost", "Cost", "Costar, precio", "Cost", "Cost", "Cost", "Cost"));
			add(new VerboIrregular("Cut", "Cot", "Cortar", "Cut", "Cot", "Cut", "Cot"));
			add(new VerboIrregular("Deal", "Diel", "Tratar, negociar, reparto", "Dealt", "Delt", "Dealt", "Delt"));
			add(new VerboIrregular("Dig", "Dig", "Cabar", "Dug", "Dog", "Dug", "Dog"));
			add(new VerboIrregular("Do", "Du", "Hacer", "Did", "Did", "Done", "Don"));
			add(new VerboIrregular("Draw", "Dra", "Dibujar, sacar, extraer, empate, sacar", "Drew", "Druu", "Drawn", "Drawn"));
			add(new VerboIrregular("Dream", "Drim", "Soñar", "Dreamt/Dreamed", "Dramt/Drimd", "Dreamt/Dreamed", "Dramt/Drim"));
			add(new VerboIrregular("Drink", "Drink", "Beber", "Drank", "Drank", "Drunk", "Dronk"));
			add(new VerboIrregular("Drive", "Draiv", "Conducir", "Drove", "Drouv", "Driven", "Driven"));
			add(new VerboIrregular("Eat", "Iit", "Comer", "Ate", "Eit", "Eaten", "Itn"));
			add(new VerboIrregular("Fall", "Fool", "Caer", "Fell", "Fell", "Fallen", "Follen"));
			add(new VerboIrregular("Feed", "Fiid", "Alimentar", "Fed", "Fed", "Fed", "Fed"));
			add(new VerboIrregular("Feel", "Fiil", "Sentir, tocar", "Felt", "Felt", "Felt", "Felt"));
			add(new VerboIrregular("Fight", "Faight", "Luchar", "Fought", "Foot", "Fought", "Foot"));
			add(new VerboIrregular("Find", "Faind", "Hallar, encontrar", "Found", "Faund", "Found", "Faund"));
			add(new VerboIrregular("Fly", "Flay", "Volar", "Flew", "Fluu", "Flow", "Flouw"));
			add(new VerboIrregular("Forbid", "Forbid", "Prohibir", "Forbade", "Forbeid", "Forbidden", "Forbiddn"));
			add(new VerboIrregular("Forgive", "Forgiv", "Perdonar", "Forgave", "Forgeiv", "Forgiven", "Forgiven"));
			add(new VerboIrregular("Freeze", "Friiz", "Congelar", "Froze", "Fouz", "Frozen", "Frouzen"));
			add(new VerboIrregular("Get", "Get", "Obtener, llegar a, ponerse", "Got", "Gat/Got", "Got", "Gat/Got"));
			add(new VerboIrregular("Give", "Giv", "Dar, otorgar, entregar", "Gave", "Geiv", "Given", "Given"));
			add(new VerboIrregular("Go", "Gou", "Ir, vamos", "Went", "Went", "Gone", "Gon"));
			add(new VerboIrregular("Grow", "Grow", "Crecer", "Grew", "Gruu", "Grown", "Grown"));
			add(new VerboIrregular("Hang", "Hang", "Colgar", "Hung", "Hong", "Hung", "Hong"));
			add(new VerboIrregular("Have", "Hav", "Tener, haber", "Had", "Had", "Had", "Had"));
			add(new VerboIrregular("Hear", "Hir", "Escuchar, oir", "Heard", "Herd", "Heard", "Herd"));
			add(new VerboIrregular("Hide", "Haid", "Esconder, ocultar", "Hid", "Hid", "Hidden", "Hiddn"));
			add(new VerboIrregular("Hit", "Hit", "Golpear, pegar", "Hit", "Hit", "Hit", "Hit"));
			add(new VerboIrregular("Hold", "Hold", "Sostener, agarrar", "Held", "Held", "Held", "Held"));
			add(new VerboIrregular("Hurt", "Hurt/Hert", "Herir, lastimar", "Hurt", "Hurt/Hert", "Hurt", "Hurt/Hert"));
			add(new VerboIrregular("Keep", "Kiip", "Conservar, quedarse, guardar, lastimar", "Kept", "Kept", "Kept", "Kept"));
			add(new VerboIrregular("Know", "Now", "Saber, conocer", "Knew", "Niu", "Known", "Nown"));
			add(new VerboIrregular("Lay", "Ley", "Poner, colocar, tenderse, hechar", "Laid", "Leid", "Laid", "Leid"));
			add(new VerboIrregular("Lead", "Liid", "Conducir, llevar, dirigir", "Led", "Led", "Led", "Led"));
			add(new VerboIrregular("Learn", "Lern", "Aprender", "Lernt/Lerned", "Lernt/Lernd", "Lernt/Lerned", "Lernt/Lernd"));
			add(new VerboIrregular("Leave", "Liiv", "Dejar", "Left", "Left", "Left", "Left"));
			add(new VerboIrregular("Lend", "Lend", "Prestar", "Lend", "Left", "Left", "Left"));
			add(new VerboIrregular("Lend", "Lend", "Permitir", "Let", "Let", "Let", "Let"));
			add(new VerboIrregular("Lie", "Lai", "Mentir", "Lay", "Ley", "Lain", "Lein"));
			add(new VerboIrregular("Light", "Laight", "Encender, prender", "Lit", "Lit", "Lit", "Lit"));
			add(new VerboIrregular("Lose", "Luus", "Perder", "Lost", "Lost", "Lost", "Lost"));
			add(new VerboIrregular("Make", "Meike", "Hacer", "Made", "Meid", "Made", "Meid"));
			add(new VerboIrregular("Mean", "Miin", "Significar", "Meant", "Ment", "Meant", "Ment"));
			add(new VerboIrregular("Meet", "Miit", "Encontrar, conocer", "Met", "Met", "Met", "Met"));
			add(new VerboIrregular("Pay", "Pey", "Pagar, abonar, rendir", "Paid", "Peid", "Paid", "Peid"));
			add(new VerboIrregular("Put", "Put", "Poner", "Put", "Put", "Put", "Put"));
			add(new VerboIrregular("Read", "Riid", "Leer", "Read", "Red", "Read", "Red"));
			add(new VerboIrregular("Ride", "Raid", "Montar, andar, pasear", "Rode", "Roud", "Ridden", "Riddn"));
			add(new VerboIrregular("Ring", "Ring", "Llamar, sonar", "Rang", "Rang", "Rung", "Rong"));
			add(new VerboIrregular("Rise", "Raise", "Subir, crecer, levantarse", "Rose", "Rous", "Risen", "Risen"));
			add(new VerboIrregular("Run", "Ran", "Correr", "Ran", "Raan", "Run", "Ran"));
			add(new VerboIrregular("Say", "Sey", "Decir", "Said", "Sed", "Said", "Sed"));
			add(new VerboIrregular("See", "Sii", "Ver", "Saw", "Soo", "Seen", "Siin"));
			add(new VerboIrregular("Sell", "Sell", "Vender", "Sold", "Sold", "Sold", "Sold"));
			add(new VerboIrregular("Send", "Send", "Mandar, enviar", "Sent", "Sent", "Sent", "Sent"));
			add(new VerboIrregular("Set", "Send", "Poner, establecer, fijar", "Set", "Set", "Set", "Set"));
			add(new VerboIrregular("Shake", "Sheik", "Sacudir, batir, temblar", "Shook", "Shuuk", "Shaken", "Sheiken"));
			add(new VerboIrregular("Shine", "Shain", "Brillar", "Shone", "Shon", "Shone", "Shon"));
			add(new VerboIrregular("Shoot", "Shuut", "Disparar", "Shot", "Shot/Shat", "Shot", "Shot/Shat"));
			add(new VerboIrregular("Show", "Shouw", "Mostrar", "Showed", "Shouwd", "Shown", "Shouwn"));
			add(new VerboIrregular("Shut", "Shat", "Cerrar", "Shut", "Shat", "Shut", "Shat"));
			add(new VerboIrregular("Sing", "Sing", "Cantar", "Sang", "Saeng", "Sung", "Song"));
			add(new VerboIrregular("Sink", "Sink", "Hundir, descender", "Sank", "Saenk", "Sunk", "Sonk"));
			add(new VerboIrregular("Sit", "Sit", "Sentarse", "Sat", "Sat", "Sat", "Sat"));
			add(new VerboIrregular("Sleep", "Sliip", "Dormir", "Slept", "Slept", "Slept", "Slept"));
			add(new VerboIrregular("Speak", "Spik", "Hablar", "Spoke", "Spouk", "Spoken", "Spouken"));
			add(new VerboIrregular("Spell", "Spell", "Deletrear", "Spelt/Spelled", "Spelt/Spelld", "Spelt/Spelled", "Spelt/Spelld"));
			add(new VerboIrregular("Spend", "Spend", "Gastar, agotar", "Spent", "Spent", "Spent", "Spent"));
			add(new VerboIrregular("Stand", "Stand", "Estar en pie, sostener", "Stood", "Stuud", "Stood", "Stuud"));
			add(new VerboIrregular("Steal", "Stil", "Robar", "Stole", "Stoul", "Stolen", "Stoulen"));
			add(new VerboIrregular("Stick", "Stick/Steck", "Pegar, adherir", "Stuck", "Stock", "Stuck", "Stock"));
			add(new VerboIrregular("Swim", "Swim", "Nadar", "Swam", "Swaem", "Swum", "Swom"));
			add(new VerboIrregular("Take", "Teik", "Tomar", "Took", "Tuuk", "Taken", "Teiken"));
			add(new VerboIrregular("Teach", "Tich", "Enseñar", "Taught", "Toot", "Taught", "Toot"));
			add(new VerboIrregular("Tear", "Tier", "Rasgar, arrancar", "Tore", "Toor", "Torn", "Torn"));
			add(new VerboIrregular("Tell", "Tell", "Decir", "Told", "Told", "Told", "Told"));
			add(new VerboIrregular("Think", "Think", "Pensar", "Thought", "Zoot", "Thought", "Zoot"));
			add(new VerboIrregular("Throw", "Throw", "Arrojar, tirar, lanzar", "Threw", "Thruu", "Thrown", "Thrown"));
			add(new VerboIrregular("Understand", "Anderstand", "Entender, comprender", "Understood", "Anderstuud", "Understood", "Anderstuud"));
			add(new VerboIrregular("Wake", "Weik", "Despertar", "Woke", "Wouk", "Woken", "Wouken"));
			add(new VerboIrregular("Wear", "Wear/Wea", "Usar, llevar puesto", "Wore", "Wuor/Wúo", "Worn", "Worn"));
			add(new VerboIrregular("Win", "Win", "Ganar", "Won", "Wan", "Won", "Wan"));
			add(new VerboIrregular("Write", "Write", "Escribir", "Wrote", "Wrout", "Written", "Writtn"));
		}};
	}

	public List<Palabra> getPalabras(boolean faciles, boolean normales, boolean dificiles) {
		return realmService.getPalabrasPorDificultad(getDificultades(faciles, normales, dificiles));
	}

	public List<VerboIrregular> getVerbosIrregulares(boolean faciles, boolean normales, boolean dificiles) {
		return realmService.getIrregularVerbsProblematicos(getDificultades(faciles, normales, dificiles));
	}

	private Integer[] getDificultades(boolean faciles, boolean normales, boolean dificiles) {
		List<Integer> dificultadesLista = new ArrayList<>();

		if (faciles) {
			dificultadesLista.add(1);
		}
		if (normales) {
			dificultadesLista.add(2);
		}
		if (dificiles) {
			dificultadesLista.add(3);
		}

		Integer[] dificultades = new Integer[dificultadesLista.size()];
		return dificultadesLista.toArray(dificultades);
	}

	public void insertarDatosSinModificarPalabrasProblematicas() {

		// ----------------- Palabras
		List<Palabra> listaPalabrasBD = realmService.getPalabras();
		List<Palabra> listaPalabrasEstatica = getPalabrasEstaticas();

		Palabra palabraEncontrada;
		for (Palabra x : listaPalabrasEstatica) {

			palabraEncontrada = checkearPalabraExistente(listaPalabrasBD, x);

			if (palabraEncontrada != null) {
				x.setDificultad(palabraEncontrada.getDificultad());
			}
		}

		// ----------------- Verbos Irregulares
		List<VerboIrregular> listaVerbosIrregularesBD = realmService.getIrregularVerbs();
		List<VerboIrregular> listaVerbosIrregularesEstatica = getVerbosIrregularesEstaticos();

		VerboIrregular verboIrregularEncontrado;
		for (VerboIrregular x : listaVerbosIrregularesEstatica) {
			verboIrregularEncontrado = checkearVerboIrregularExistente(listaVerbosIrregularesBD, x);

			if (verboIrregularEncontrado != null) {
				x.setDificultad(verboIrregularEncontrado.getDificultad());
			}
		}

		realmService.eliminarTodo();
		realmService.insertarPalabras(listaPalabrasEstatica);
		realmService.insertarIrregularVerbs(listaVerbosIrregularesEstatica);
	}

	public Palabra checkearPalabraExistente(List<Palabra> lista, Palabra palabra) {
		Palabra palabraEncontrada = null;

		for (Palabra x : lista) {
			if (x.getPalabraIng().equals(palabra.getPalabraIng())) {
				palabraEncontrada = x;
				break;
			}
		}
		return palabraEncontrada;
	}

	public VerboIrregular checkearVerboIrregularExistente(List<VerboIrregular> lista, VerboIrregular palabra) {
		VerboIrregular verboIrregularEncontrado = null;

		for (VerboIrregular x : lista) {
			if (x.getInfinitivo().equals(palabra.getInfinitivo())) {
				verboIrregularEncontrado = x;
				break;
			}
		}
		return verboIrregularEncontrado;
	}

	//en el juego de ver una palabra cuando pasa una palabra cullo significado es largo el boton de next pasa a quedar bien pegado a la derecha
	// Fijarse que en el juego de palabras el next cuando se estira la traduccion se sigue viendo mal..

	public boolean compararPalabra(String palabra1, String palabra2) {
		return palabra1.trim().equalsIgnoreCase(palabra2);
	}
}
