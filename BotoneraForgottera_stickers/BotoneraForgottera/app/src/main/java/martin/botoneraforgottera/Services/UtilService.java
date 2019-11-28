package martin.botoneraforgottera.Services;

import java.util.ArrayList;
import java.util.List;

import martin.botoneraforgottera.Models.Audio;
import martin.botoneraforgottera.Models.Tag;
import martin.botoneraforgottera.R;

public class UtilService {

	private String TAG_UBER = "#uber";
	private String TAG_FABRIO = "#fabrio";
	private String TAG_FIURI = "#iuri";
	private String TAG_MACREE = "#macree";
	private String TAG_GOL = "#gol";
	private String TAG_RIVER = "#river";
	private String TAG_LUCHON = "#luchon";
	private String TAG_PELOTUDO = "#pelotudo";
	private String TAG_SONIDO = "#sonido";
	private String TAG_SHIT_MUSIC = "#shitmusic";
	private String TAG_RISA = "#risa";
	private String TAG_ERUCTO = "#eructo";
	private String TAG_PEDO = "#pedo";
	private String TAG_LUACHA = "#luacha";
	private String TAG_HIJO_DE_PUTA = "#hdp";
	private String TAG_SOCIALISMO = "#socialismo";
	private String TAG_MARCE = "#marce";
	private String TAG_PERO_MAS_BIEN = "#peromasbienloquita";
	private String TAG_OSHTIAPUTA = "#oshtiaputa";
	private String TAG_SALUDO = "#saludo";
	private String TAG_ESE_SOI_IO = "#esesoiio";
	private String TAG_RAMI = "#rami";
	private String TAG_AH_PERO_ANOCHE = "#ahperoanoche";
	private String TAG_YA_TE_RAJO = "#yaterajo";
	private String TAG_MANE = "#marce";
	private String TAG_GAJTAUN = "#gajtaun";
	private String TAG_BLACK = "#black";
	private String TAG_KUKA = "#kuka";
	private String TAG_JODER = "#joder";
	private String TAG_EISH = "#eish";
	private String TAG_AY_QUE_RECO_MAME = "#ayquerecomame";
	private String TAG_NIGUIN = "#niguin";
	private String TAG_TREN = "#tren";
	private String TAG_BASTA_CHICOS = "#bastachicos";
	private String TAG_FORT = "#fort";
	private String TAG_PASA_EL_LINK = "#pasaellink";
	private String TAG_SIMPSONS = "#simpsons";
	private String TAG_GULI = "#guli";
	private String TAG_JALEA = "#jalea";
	private String TAG_GRITO = "#grito";
	private String TAG_VOZ_BOLUDO = "#vozboludo";
	private String TAG_POIO = "#poio";
	private String TAG_ROTISERIA = "#rotiseria";
	private String TAG_COMAN_POIA = "#comanpoia";
	private String TAG_NOO = "#noo";
	private String TAG_CAGON = "#cagon";
	private String TAG_VIRGOCHO = "#virgocho";
	private String TAG_PUTACO = "#putaco";
	private String TAG_CARAMIERDA = "#caramierda";
	private String TAG_FH2 = "#fh2";
	private String TAG_FEMINISTA = "#feminista";

	public List<Audio> getAudios() {

		return new ArrayList<Audio>() {{
			add(new Audio(R.raw.audio_1, "Te voy a tocar la jalea", new ArrayList<Tag>() {{
				add(new Tag(TAG_UBER));
				add(new Tag(TAG_JALEA));
			}}));
			add(new Audio(R.raw.audio_2, "No pichu noo!", new ArrayList<Tag>() {{
				add(new Tag(TAG_LUACHA));
				add(new Tag(TAG_GRITO));
				add(new Tag(TAG_NOO));
			}}));
			add(new Audio(R.raw.audio_3, "Ay que reco mamee", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_AY_QUE_RECO_MAME));
			}}));
			add(new Audio(R.raw.audio_4, "Pero por que hace esa voz de boludooo", new ArrayList<Tag>() {{
				add(new Tag(TAG_LUACHA));
				add(new Tag(TAG_VOZ_BOLUDO));
			}}));
			add(new Audio(R.raw.audio_5, "Poioooo", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_POIO));
				add(new Tag(TAG_SALUDO));
			}}));
			add(new Audio(R.raw.audio_6, "Uy mira ese guli que lendoo", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
			}}));
			add(new Audio(R.raw.audio_7, "Heee por qué me decis eso?", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
			}}));
			add(new Audio(R.raw.audio_8, "Hola si rotiseria?", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_ROTISERIA));
			}}));
			add(new Audio(R.raw.audio_9, "Ay que reco mameee (2)", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_AY_QUE_RECO_MAME));
			}}));
			add(new Audio(R.raw.audio_10, "Te lo dije a vos? a mi me parece que no", new ArrayList<Tag>() {{
				add(new Tag(TAG_UBER));
			}}));
			add(new Audio(R.raw.audio_11, "Ya mismo estoy entrando a la pagina", new ArrayList<Tag>() {{
				add(new Tag(TAG_GAJTAUN));
			}}));
			add(new Audio(R.raw.audio_12, "Coman poiaa", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_COMAN_POIA));
			}}));
			add(new Audio(R.raw.audio_13, "Nooo", new ArrayList<Tag>() {{
				add(new Tag(TAG_GAJTAUN));
				add(new Tag(TAG_NOO));
			}}));
			add(new Audio(R.raw.audio_14, "NOOOO", new ArrayList<Tag>() {{
				add(new Tag(TAG_GAJTAUN));
				add(new Tag(TAG_NOO));
			}}));
			add(new Audio(R.raw.audio_15, "Lo vas a borrar porque sos asi cagoon", new ArrayList<Tag>() {{
				add(new Tag(TAG_GAJTAUN));
				add(new Tag(TAG_CAGON));
			}}));
			add(new Audio(R.raw.audio_16, "Caramierda...", new ArrayList<Tag>() {{
				add(new Tag(TAG_LUACHA));
				add(new Tag(TAG_CARAMIERDA));
			}}));
			add(new Audio(R.raw.audio_17, "Cosa de hombres carajo", new ArrayList<Tag>() {{
				add(new Tag(TAG_UBER));
			}}));
			add(new Audio(R.raw.audio_18, "Para loco, pensa en nosotros, en los pibes", new ArrayList<Tag>() {{
				add(new Tag(TAG_UBER));
			}}));
			add(new Audio(R.raw.audio_19, "Salio alto dia de forgotteeen", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_FH2));
			}}));
			add(new Audio(R.raw.audio_20, "Ay que reco mamee (3)", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_AY_QUE_RECO_MAME));
			}}));
			add(new Audio(R.raw.audio_21, "Ay que reco mamee (4)", new ArrayList<Tag>() {{
				add(new Tag(TAG_GULI));
				add(new Tag(TAG_AY_QUE_RECO_MAME));
			}}));
			add(new Audio(R.raw.audio_22, "Ay que lindo manee", new ArrayList<Tag>() {{
				add(new Tag(TAG_GULI));
			}}));
			add(new Audio(R.raw.audio_23, "Ay que reco mamee (5)", new ArrayList<Tag>() {{
				add(new Tag(TAG_GAJTAUN));
				add(new Tag(TAG_AY_QUE_RECO_MAME));
			}}));
			add(new Audio(R.raw.audio_24, "Un heroe, un heroee", new ArrayList<Tag>() {{
				add(new Tag(TAG_GAJTAUN));
				add(new Tag(TAG_NIGUIN));
			}}));
			add(new Audio(R.raw.audio_25, "Que borras", new ArrayList<Tag>() {{
				add(new Tag(TAG_UBER));
				add(new Tag(TAG_CAGON));
			}}));
			add(new Audio(R.raw.audio_26, "Mírenlo.. el putaco", new ArrayList<Tag>() {{
				add(new Tag(TAG_UBER));
				add(new Tag(TAG_CAGON));
			}}));
			add(new Audio(R.raw.audio_27, "Ese virgocho soi io", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_VIRGOCHO));
				add(new Tag(TAG_ESE_SOI_IO));
			}}));
			add(new Audio(R.raw.audio_28, "Creo que estoy ciego...", new ArrayList<Tag>() {{
				add(new Tag(TAG_NIGUIN));
			}}));
			add(new Audio(R.raw.audio_29, "Vos no sos de fiar, cabronazo", new ArrayList<Tag>() {{
				add(new Tag(TAG_LUACHA));
			}}));
			add(new Audio(R.raw.audio_30, "Ay que reco mamee (6)", new ArrayList<Tag>() {{
				add(new Tag(TAG_GAJTAUN));
				add(new Tag(TAG_AY_QUE_RECO_MAME));
			}}));
			add(new Audio(R.raw.audio_31, "Alto ñoqui kirchnerista sos viste...", new ArrayList<Tag>() {{
				add(new Tag(TAG_BLACK));
				add(new Tag(TAG_KUKA));
			}}));
			add(new Audio(R.raw.audio_32, "Que vas a ser fachero, sos un ñoqui de mier...", new ArrayList<Tag>() {{
				add(new Tag(TAG_BLACK));
				add(new Tag(TAG_KUKA));
			}}));
			add(new Audio(R.raw.audio_33, "JO-DER", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_JODER));
			}}));
			add(new Audio(R.raw.audio_34, "Siii io doy todo mi amor", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
			}}));
			add(new Audio(R.raw.audio_35, "Mirá como estan esas nuvecitaas", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
			}}));
			add(new Audio(R.raw.audio_36, "Ay nene, por fin una foto no mochista", new ArrayList<Tag>() {{
				add(new Tag(TAG_UBER));
				add(new Tag(TAG_FEMINISTA));
			}}));
			add(new Audio(R.raw.audio_37, "Que me digiste gil? TE VOY A PARTIR LA CABEZA!", new ArrayList<Tag>() {{
				add(new Tag(TAG_UBER));
			}}));
			add(new Audio(R.raw.audio_38, "Hace 20 años que no voy a uno de esos", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
			}}));
			add(new Audio(R.raw.audio_39, "Che capaz que en media hora estoy, van a estar?", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_FH2));
			}}));
			add(new Audio(R.raw.audio_40, "Si papa veni por favoor", new ArrayList<Tag>() {{
				add(new Tag(TAG_NIGUIN));
			}}));
			add(new Audio(R.raw.audio_41, "Se fue poio esta muerto", new ArrayList<Tag>() {{
				add(new Tag(TAG_NIGUIN));
			}}));
			add(new Audio(R.raw.audio_42, "Ah ok..", new ArrayList<Tag>() {{
				add(new Tag(TAG_UBER));
			}}));
			add(new Audio(R.raw.audio_43, "* Sonido de pedo *", new ArrayList<Tag>() {{
				add(new Tag(TAG_PEDO));
				add(new Tag(TAG_SONIDO));
			}}));
			add(new Audio(R.raw.audio_44, "Ja ja ja, que buen chiste", new ArrayList<Tag>() {{
				add(new Tag(TAG_GAJTAUN));
			}}));
			add(new Audio(R.raw.audio_45, "Que pasa aca, no se puede mandar fotod de mujeres desnudas", new ArrayList<Tag>() {{
				add(new Tag(TAG_GAJTAUN));
			}}));
			add(new Audio(R.raw.audio_46, "Ah listo, ya te rajo", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_YA_TE_RAJO));
			}}));
			add(new Audio(R.raw.audio_47, "Cuentenme algo, me aburro", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
			}}));
			add(new Audio(R.raw.audio_48, "No tuvo ni puta gracia guli", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
			}}));
			add(new Audio(R.raw.audio_49, "Ubeeer", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_SALUDO));
			}}));
			add(new Audio(R.raw.audio_50, "Puede ser algo que comiste que te partió la boca", new ArrayList<Tag>() {{
				add(new Tag(TAG_UBER));
			}}));
			add(new Audio(R.raw.audio_51, "* PAC PAC PAC PAC *", new ArrayList<Tag>() {{
				add(new Tag(TAG_SONIDO));
			}}));
			add(new Audio(R.raw.audio_52, "Pechuleeeen", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_SALUDO));
			}}));
			add(new Audio(R.raw.audio_53, "PECHULEEEEEEN", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_SALUDO));
			}}));
			add(new Audio(R.raw.audio_54, "Ah pero anoche...", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_AH_PERO_ANOCHE));
			}}));
			add(new Audio(R.raw.audio_55, "Che buen tipo este pedro eh...", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
			}}));
			add(new Audio(R.raw.audio_56, "Ecualam", new ArrayList<Tag>() {{
				add(new Tag(TAG_GAJTAUN));
				add(new Tag(TAG_EISH));
			}}));
			add(new Audio(R.raw.audio_57, "Ay que reco mamee (7)", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_AY_QUE_RECO_MAME));
			}}));
			add(new Audio(R.raw.audio_58, "Maneeee", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_SALUDO));
			}}));
			add(new Audio(R.raw.audio_59, "Gastoncilloooo mi amol", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_SALUDO));
			}}));
			add(new Audio(R.raw.audio_60, "Jodeeeeer", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_JODER));
			}}));
			add(new Audio(R.raw.audio_61, "Dicimula la envidia pollooo", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
			}}));
			add(new Audio(R.raw.audio_62, "Hola si rotiseria? (2)", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_ROTISERIA));
			}}));
			add(new Audio(R.raw.audio_63, "Ay que reco mamee (8)", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_AY_QUE_RECO_MAME));
			}}));
			add(new Audio(R.raw.audio_64, "PECHULEEEEEEN (2)", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_SALUDO));
			}}));
			add(new Audio(R.raw.audio_65, "PECHULEEEEEEN (3)", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_SALUDO));
			}}));
			add(new Audio(R.raw.audio_66, "Che cuentenme algo, hijos de mil putas", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_HIJO_DE_PUTA));
			}}));
			add(new Audio(R.raw.audio_67, "Al carajo, al carajo, que se vayan al carajo", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
			}}));
			add(new Audio(R.raw.audio_68, "Haaaa....", new ArrayList<Tag>() {{
				add(new Tag(TAG_NIGUIN));
			}}));
			add(new Audio(R.raw.audio_69, "Ay que rico", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_AY_QUE_RECO_MAME));
			}}));
			add(new Audio(R.raw.audio_70, "Terrible masacre..", new ArrayList<Tag>() {{
				add(new Tag(TAG_RAMI));
			}}));
			add(new Audio(R.raw.audio_71, "Ese culiado soi io", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_ESE_SOI_IO));
			}}));
			add(new Audio(R.raw.audio_72, "Ha pero cuando la invitas a la campaña..", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_AH_PERO_ANOCHE));
			}}));
			add(new Audio(R.raw.audio_73, "Ay que reco mamee (9)", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_AY_QUE_RECO_MAME));
			}}));
			add(new Audio(R.raw.audio_74, "Hola si, tengo una llamada para pollo del 2007..", new ArrayList<Tag>() {{
				add(new Tag(TAG_UBER));
				add(new Tag(TAG_PELOTUDO));
			}}));
			add(new Audio(R.raw.audio_75, "Invitalaaa sé luchón", new ArrayList<Tag>() {{
				add(new Tag(TAG_FABRIO));
				add(new Tag(TAG_LUCHON));
			}}));
			add(new Audio(R.raw.audio_76, "Escucha, escucha * PAC PAC PAC *", new ArrayList<Tag>() {{
				add(new Tag(TAG_LUACHA));
				add(new Tag(TAG_SONIDO));
			}}));
			add(new Audio(R.raw.audio_77, "Son un asco loco", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
			}}));
			add(new Audio(R.raw.audio_78, "Eeeeeel trabajadooooor", new ArrayList<Tag>() {{
				add(new Tag(TAG_FABRIO));
			}}));
			add(new Audio(R.raw.audio_79, "Estas re lindo uber..", new ArrayList<Tag>() {{
				add(new Tag(TAG_GAJTAUN));
			}}));
			add(new Audio(R.raw.audio_80, "Furiiiii, caramierda", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_SALUDO));
			}}));
			add(new Audio(R.raw.audio_81, "Holaaaa", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_SALUDO));
			}}));
			add(new Audio(R.raw.audio_82, "Gracias uber... el unico quie banco de todo este puto grupo!", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
			}}));
			add(new Audio(R.raw.audio_83, "PECHULEEEEEEN (4)", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_SALUDO));
			}}));
			add(new Audio(R.raw.audio_84, "JODEEEEEER (2)", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_JODER));
			}}));
			add(new Audio(R.raw.audio_85, "PECHULEEEEEEN (5)", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_SALUDO));
			}}));
			add(new Audio(R.raw.audio_86, "Ay que reco mameee", new ArrayList<Tag>() {{
				add(new Tag(TAG_UBER));
				add(new Tag(TAG_AY_QUE_RECO_MAME));
			}}));
			add(new Audio(R.raw.audio_87, "Ay que reco mameee", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_AY_QUE_RECO_MAME));
			}}));
			add(new Audio(R.raw.audio_88, "Para, para no me asustes boludo, eso puede pasar?", new ArrayList<Tag>() {{
				add(new Tag(TAG_LUACHA));
			}}));
			add(new Audio(R.raw.audio_89, "Uy la puta madre, cague...", new ArrayList<Tag>() {{
				add(new Tag(TAG_LUACHA));
			}}));
			add(new Audio(R.raw.audio_90, "* Eructo*", new ArrayList<Tag>() {{
				add(new Tag(TAG_SONIDO));
				add(new Tag(TAG_ERUCTO));
			}}));
			add(new Audio(R.raw.audio_91, "Me cago en dios y lña puta madre que los parió", new ArrayList<Tag>() {{
				add(new Tag(TAG_SONIDO));
				add(new Tag(TAG_MARCE));
			}}));
			add(new Audio(R.raw.audio_92, "PECHULEEEEEEN (6)", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_SALUDO));
			}}));
			add(new Audio(R.raw.audio_93, "Ay que reco mameee (2)", new ArrayList<Tag>() {{
				add(new Tag(TAG_UBER));
				add(new Tag(TAG_AY_QUE_RECO_MAME));
			}}));
			add(new Audio(R.raw.audio_94, "Ay que reco mameee (2)", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_AY_QUE_RECO_MAME));
			}}));
			add(new Audio(R.raw.audio_95, "Coman poiaaa", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_COMAN_POIA));
			}}));
			add(new Audio(R.raw.audio_96, "Hola si rotiseria?", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_ROTISERIA));
			}}));
			add(new Audio(R.raw.audio_97, "Fabriiiii", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_SALUDO));
			}}));
			add(new Audio(R.raw.audio_98, "Que te pasa cabeza de culo?", new ArrayList<Tag>() {{
				add(new Tag(TAG_UBER));
			}}));
			add(new Audio(R.raw.audio_99, "Pero no me faltes el respeto loco", new ArrayList<Tag>() {{
				add(new Tag(TAG_UBER));
			}}));
			add(new Audio(R.raw.audio_100, "Maneee", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_SALUDO));
			}}));
			add(new Audio(R.raw.audio_101, "Dale mane, no intentes decir que tu vida es una puta mierda...", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
			}}));
			add(new Audio(R.raw.audio_102, "Ay pero que emoción", new ArrayList<Tag>() {{
				add(new Tag(TAG_GULI));
			}}));
			add(new Audio(R.raw.audio_103, "Que no ostia, ya dije que es una amiga", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_OSHTIAPUTA));
			}}));
			add(new Audio(R.raw.audio_104, "Ay que rico furi", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_AY_QUE_RECO_MAME));
			}}));
			add(new Audio(R.raw.audio_105, "No se confundan, no pague por eso", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_AY_QUE_RECO_MAME));
			}}));
			add(new Audio(R.raw.audio_106, "Aguante river iiiijiji!", new ArrayList<Tag>() {{
				add(new Tag(TAG_FABRIO));
				add(new Tag(TAG_RIVER));
			}}));
			add(new Audio(R.raw.audio_107, "Dejense de mierdas, ostias", new ArrayList<Tag>() {{
				add(new Tag(TAG_FABRIO));
				add(new Tag(TAG_OSHTIAPUTA));
			}}));
			add(new Audio(R.raw.audio_108, "Poiooooooo (2)", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_SALUDO));
			}}));
			add(new Audio(R.raw.audio_109, "PECHULEEEEEEN (7)", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_SALUDO));
			}}));
			add(new Audio(R.raw.audio_110, "Holiiiii", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_SALUDO));
			}}));
			add(new Audio(R.raw.audio_111, "Pedritoooo", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_SALUDO));
			}}));
			add(new Audio(R.raw.audio_112, "Coman poiaaaa", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_COMAN_POIA));
			}}));
			add(new Audio(R.raw.audio_113, "Pero mas bien loquita", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_PERO_MAS_BIEN));
			}}));
			add(new Audio(R.raw.audio_114, "No toquen las bolas loco", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
			}}));
			add(new Audio(R.raw.audio_115, "Y io lo amo", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
			}}));
			add(new Audio(R.raw.audio_116, "Que te haces el protagonista hijo de puta", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_HIJO_DE_PUTA));
			}}));
			add(new Audio(R.raw.audio_117, "Se olle bieeen", new ArrayList<Tag>() {{
				add(new Tag(TAG_NIGUIN));
			}}));
			add(new Audio(R.raw.audio_118, "Pero veni y decimelo en la cara pelotudo", new ArrayList<Tag>() {{
				add(new Tag(TAG_LUACHA));
			}}));
			add(new Audio(R.raw.audio_119, "jajaja que hijo de puta", new ArrayList<Tag>() {{
				add(new Tag(TAG_FABRIO));
				add(new Tag(TAG_HIJO_DE_PUTA));
			}}));
			add(new Audio(R.raw.audio_120, "Gooool mierdaa", new ArrayList<Tag>() {{
				add(new Tag(TAG_FABRIO));
				add(new Tag(TAG_GOL));
			}}));
			add(new Audio(R.raw.audio_121, "Ah pero anocheee", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_AH_PERO_ANOCHE));
			}}));
			add(new Audio(R.raw.audio_122, "Nooooooooo....", new ArrayList<Tag>() {{
				add(new Tag(TAG_LUACHA));
				add(new Tag(TAG_NOO));
			}}));
			add(new Audio(R.raw.audio_123, "Cojermela ahora mismo dudud..", new ArrayList<Tag>() {{
				add(new Tag(TAG_NIGUIN));
				add(new Tag(TAG_SIMPSONS));
			}}));
			add(new Audio(R.raw.audio_124, "Ay que recoooooo", new ArrayList<Tag>() {{
				add(new Tag(TAG_NIGUIN));
				add(new Tag(TAG_AY_QUE_RECO_MAME));
			}}));
			add(new Audio(R.raw.audio_125, "Pasame el link", new ArrayList<Tag>() {{
				add(new Tag(TAG_NIGUIN));
				add(new Tag(TAG_PASA_EL_LINK));
			}}));
			add(new Audio(R.raw.audio_126, "Jajaja es moy bueno", new ArrayList<Tag>() {{
				add(new Tag(TAG_NIGUIN));
			}}));
			add(new Audio(R.raw.audio_127, "La recalcada concha de tu hermana macri", new ArrayList<Tag>() {{
				add(new Tag(TAG_FABRIO));
				add(new Tag(TAG_MACREE));
			}}));
			add(new Audio(R.raw.audio_128, "Eh no, no no, mane pasa mas memes", new ArrayList<Tag>() {{
				add(new Tag(TAG_UBER));
			}}));
			add(new Audio(R.raw.audio_129, "Basta chicos", new ArrayList<Tag>() {{
				add(new Tag(TAG_NIGUIN));
				add(new Tag(TAG_BASTA_CHICOS));
				add(new Tag(TAG_FORT));
			}}));
			add(new Audio(R.raw.audio_130, "PECHULEEEEEEN (8)", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_SALUDO));
			}}));
			add(new Audio(R.raw.audio_131, "PECHULEEEEEEN (9)", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_SALUDO));
			}}));
			add(new Audio(R.raw.audio_132, "Poiooooooo (3)", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_SALUDO));
			}}));
			add(new Audio(R.raw.audio_133, "Sos un hijo de puta pocho, sos un hijo de puta!", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_HIJO_DE_PUTA));
			}}));
			add(new Audio(R.raw.audio_134, "Es MUY mane", new ArrayList<Tag>() {{
				add(new Tag(TAG_LUACHA));
			}}));
			add(new Audio(R.raw.audio_135, "JO-DER", new ArrayList<Tag>() {{
				add(new Tag(TAG_LUACHA));
				add(new Tag(TAG_JODER));
			}}));
			add(new Audio(R.raw.audio_136, "Ya no sabe mas que boludez inventar este", new ArrayList<Tag>() {{
				add(new Tag(TAG_LUACHA));
			}}));
			add(new Audio(R.raw.audio_137, "Bueno eso ya es un punto a favor tuyo", new ArrayList<Tag>() {{
				add(new Tag(TAG_NIGUIN));
			}}));
			add(new Audio(R.raw.audio_138, "* Llorando *", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_SONIDO));
			}}));
			add(new Audio(R.raw.audio_139, "PECHULEEEEEEN (10)", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_SALUDO));
			}}));
			add(new Audio(R.raw.audio_140, "Voy a ver que gil!", new ArrayList<Tag>() {{
				add(new Tag(TAG_MANE));
			}}));
			add(new Audio(R.raw.audio_141, "PECHULEEEEEEN (11)", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_SALUDO));
			}}));
			add(new Audio(R.raw.audio_142, "Te tiene mal el socialismo", new ArrayList<Tag>() {{
				add(new Tag(TAG_LUACHA));
				add(new Tag(TAG_SOCIALISMO));
			}}));
			add(new Audio(R.raw.audio_143, "Sos un hijo de puta", new ArrayList<Tag>() {{
				add(new Tag(TAG_LUACHA));
				add(new Tag(TAG_HIJO_DE_PUTA));
			}}));
			add(new Audio(R.raw.audio_144, "Guliiiiiiiiiiiiiiiiiiiiiiiiii...", new ArrayList<Tag>() {{
				add(new Tag(TAG_LUACHA));
			}}));
			add(new Audio(R.raw.audio_145, "Que onda furiii", new ArrayList<Tag>() {{
				add(new Tag(TAG_GAJTAUN));
				add(new Tag(TAG_SALUDO));
			}}));
			add(new Audio(R.raw.audio_146, "La podes cortar flaco?", new ArrayList<Tag>() {{
				add(new Tag(TAG_FIURI));
			}}));
			add(new Audio(R.raw.audio_147, "Consulta al doctor, yo soy enfermero", new ArrayList<Tag>() {{
				add(new Tag(TAG_UBER));
			}}));
			add(new Audio(R.raw.audio_148, "JAJA AJAJAJA AJAJA AJAJ", new ArrayList<Tag>() {{
				add(new Tag(TAG_UBER));
				add(new Tag(TAG_SONIDO));
				add(new Tag(TAG_RISA));
			}}));
			add(new Audio(R.raw.audio_149, "Bueno hijo de puta, no me sale, que uqeres que haga", new ArrayList<Tag>() {{
				add(new Tag(TAG_LUACHA));
				add(new Tag(TAG_HIJO_DE_PUTA));
			}}));
			add(new Audio(R.raw.audio_150, "No podes preguntar algo asi en este grupo de mierda", new ArrayList<Tag>() {{
				add(new Tag(TAG_LUACHA));
			}}));
			add(new Audio(R.raw.audio_151, "Que te pasa con mane facho hijo de mil putas?", new ArrayList<Tag>() {{
				add(new Tag(TAG_UBER));
				add(new Tag(TAG_HIJO_DE_PUTA));
			}}));
			add(new Audio(R.raw.audio_152, "Si, este, rompo culos tambien a domicilio", new ArrayList<Tag>() {{
				add(new Tag(TAG_UBER));
			}}));
			add(new Audio(R.raw.audio_153, "Es muy facil", new ArrayList<Tag>() {{
				add(new Tag(TAG_LUACHA));
			}}));
			add(new Audio(R.raw.audio_154, "No es todo lo mismo eso?", new ArrayList<Tag>() {{
				add(new Tag(TAG_LUACHA));
			}}));
			add(new Audio(R.raw.audio_155, "Los alemanes nos atacaron anoche repetidas veces", new ArrayList<Tag>() {{
				add(new Tag(TAG_GAJTAUN));
				add(new Tag(TAG_FH2));
			}}));
			add(new Audio(R.raw.audio_156, "HIJO-DE-PUTA...", new ArrayList<Tag>() {{
				add(new Tag(TAG_LUACHA));
				add(new Tag(TAG_HIJO_DE_PUTA));
			}}));
			add(new Audio(R.raw.audio_157, "Haaawwwww... que tierno...", new ArrayList<Tag>() {{
				add(new Tag(TAG_GAJTAUN));
			}}));
			add(new Audio(R.raw.audio_158, "A mi se me hace que sos marica", new ArrayList<Tag>() {{
				add(new Tag(TAG_NIGUIN));
			}}));
			add(new Audio(R.raw.audio_159, "Ay que reco mamee (43)", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_AY_QUE_RECO_MAME));
			}}));
			add(new Audio(R.raw.audio_160, "PECHULEEEEEEN (12)", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_SALUDO));
			}}));
			add(new Audio(R.raw.audio_161, "Ha si?.. bueno tu hermana", new ArrayList<Tag>() {{
				add(new Tag(TAG_UBER));
			}}));
			add(new Audio(R.raw.audio_162, "Cuere que cuere... pum pum..♫", new ArrayList<Tag>() {{
				add(new Tag(TAG_UBER));
				add(new Tag(TAG_SONIDO));
			}}));
			add(new Audio(R.raw.audio_163, "Gajtaaaaaaaaaun", new ArrayList<Tag>() {{
				add(new Tag(TAG_LUACHA));
				add(new Tag(TAG_SALUDO));
			}}));
			add(new Audio(R.raw.audio_164, "Buenos díaaaaaaaaaaas", new ArrayList<Tag>() {{
				add(new Tag(TAG_NIGUIN));
				add(new Tag(TAG_SALUDO));
			}}));
			add(new Audio(R.raw.audio_165, "Ah no? y yo que soy", new ArrayList<Tag>() {{
				add(new Tag(TAG_LUACHA));
			}}));
			add(new Audio(R.raw.audio_166, "Ay todas esas drogas, quisiera tener ahora mismo una dududu..", new ArrayList<Tag>() {{
				add(new Tag(TAG_NIGUIN));
				add(new Tag(TAG_SIMPSONS));
			}}));
			add(new Audio(R.raw.audio_167, "Chicles beldent, chicles beldent...", new ArrayList<Tag>() {{
				add(new Tag(TAG_GAJTAUN));
				add(new Tag(TAG_TREN));
			}}));
			add(new Audio(R.raw.audio_168, "Chicles beldent, chicles beldent... (2)", new ArrayList<Tag>() {{
				add(new Tag(TAG_GAJTAUN));
				add(new Tag(TAG_TREN));
			}}));
			add(new Audio(R.raw.audio_169, "Se te hizo agua la boca cogote", new ArrayList<Tag>() {{
				add(new Tag(TAG_GAJTAUN));
			}}));
			add(new Audio(R.raw.audio_170, "* Sonido de pedo (2) *", new ArrayList<Tag>() {{
				add(new Tag(TAG_PEDO));
				add(new Tag(TAG_SONIDO));
			}}));
			add(new Audio(R.raw.audio_171, "Estaba haciendo nonita?", new ArrayList<Tag>() {{
				add(new Tag(TAG_NIGUIN));
			}}));
			add(new Audio(R.raw.audio_172, "Salí de ahi ya oshtia", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_OSHTIAPUTA));
			}}));
			add(new Audio(R.raw.audio_173, "Joder", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_JODER));
			}}));
			add(new Audio(R.raw.audio_174, "Mira como esta esa rapada viejaa", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_JODER));
			}}));
			add(new Audio(R.raw.audio_175, "* Sonido de pedo (3) *", new ArrayList<Tag>() {{
				add(new Tag(TAG_PEDO));
				add(new Tag(TAG_SONIDO));
			}}));
			add(new Audio(R.raw.audio_176, "* Sonido de pedo (4) *", new ArrayList<Tag>() {{
				add(new Tag(TAG_PEDO));
				add(new Tag(TAG_SONIDO));
			}}));
			add(new Audio(R.raw.audio_177, "Por que eliminaste ese mensaje?", new ArrayList<Tag>() {{
				add(new Tag(TAG_LUACHA));
				add(new Tag(TAG_CAGON));
			}}));
			add(new Audio(R.raw.audio_178, "Hijo de puta, que vas a cocinar", new ArrayList<Tag>() {{
				add(new Tag(TAG_NIGUIN));
			}}));
			add(new Audio(R.raw.audio_179, "El hombre mira al hombreeee... y le aguanta la mmirada", new ArrayList<Tag>() {{
				add(new Tag(TAG_GAJTAUN));
				add(new Tag(TAG_SONIDO));
				add(new Tag(TAG_SHIT_MUSIC));
			}}));
			add(new Audio(R.raw.audio_180, "Mandale saludos", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_SALUDO));
			}}));
			add(new Audio(R.raw.audio_181, "Che poio hay quilombo eh", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
			}}));
			add(new Audio(R.raw.audio_182, "Hicieron trampa pocho, hicieron trampa!", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
			}}));
			add(new Audio(R.raw.audio_183, "Fabri de mi vidaa", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
			}}));
			add(new Audio(R.raw.audio_184, "PICHULEEEEEEN (13)", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_SALUDO));
			}}));
			add(new Audio(R.raw.audio_185, "Que haces despierto vos a esta hora?", new ArrayList<Tag>() {{
				add(new Tag(TAG_FABRIO));
			}}));
			add(new Audio(R.raw.audio_186, "Es sabado vieja", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
			}}));
			add(new Audio(R.raw.audio_187, "Pero mirá ese deportista papá", new ArrayList<Tag>() {{
				add(new Tag(TAG_FABRIO));
			}}));
			add(new Audio(R.raw.audio_188, "Puta madreee", new ArrayList<Tag>() {{
				add(new Tag(TAG_MARCE));
				add(new Tag(TAG_HIJO_DE_PUTA));
			}}));
			add(new Audio(R.raw.audio_189, "* Pac pac pac pac pac *", new ArrayList<Tag>() {{
				add(new Tag(TAG_SONIDO));
			}}));
		}};
	}
}
