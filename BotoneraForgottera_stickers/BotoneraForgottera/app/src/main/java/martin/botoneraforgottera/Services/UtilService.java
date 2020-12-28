package martin.botoneraforgottera.Services;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import martin.botoneraforgottera.Models.Audio;
import martin.botoneraforgottera.Models.Tag;
import martin.botoneraforgottera.R;

public class UtilService {

    //    ISSUES:
    // - Los textos de los tags no estan centrados bien verticalmente
    // - Los tags grandes se cortan
    // - No filtra bien si tiene acento. Ej pones para buscar "medico" y si hay una palabra "médico" no te lo toma

    private final String TAG_UBER = "#uber";
    private final String TAG_FABRIO = "#fabrio";
    private final String TAG_FIURI = "#fiuri";
    private final String TAG_MACREE = "#macree";
    private final String TAG_GOL = "#gol";
    private final String TAG_RIVER = "#river";
    private final String TAG_LUCHON = "#luchon";
    private final String TAG_PELOTUDO = "#pelotudo";
    private final String TAG_SONIDO = "#sonido";
    private final String TAG_SHIT_MUSIC = "#shitmusic";
    private final String TAG_RISA = "#risa";
    private final String TAG_ERUCTO = "#eructo";
    private final String TAG_PEDO = "#pedo";
    private final String TAG_LUACHA = "#luacha";
    private final String TAG_HIJO_DE_PUTA = "#hdp";
    private final String TAG_SOCIALISMO = "#socialismo";
    private final String TAG_MARCE = "#marce";
    private final String TAG_PERO_MAS_BIEN = "#peromasbienloquita";
    private final String TAG_OSHTIAPUTA = "#oshtiaputa";
    private final String TAG_SALUDO = "#saludo";
    private final String TAG_ESE_SOI_IO = "#esesoiio";
    private final String TAG_RAMI = "#rami";
    private final String TAG_AH_PERO_ANOCHE = "#ahperoanoche";
    private final String TAG_YA_TE_RAJO = "#yaterajo";
    private final String TAG_MANE = "#marce";
    private final String TAG_GAJTAUN = "#gajtaun";
    private final String TAG_BLACK = "#black";
    private final String TAG_KUKA = "#kuka";
    private final String TAG_JODER = "#joder";
    private final String TAG_EISH = "#eish";
    private final String TAG_AY_QUE_RECO_MAME = "#ayquerecomame";
    private final String TAG_NIGUIN = "#niguin";
    private final String TAG_TREN = "#tren";
    private final String TAG_BASTA_CHICOS = "#bastachicos";
    private final String TAG_FORT = "#fort";
    private final String TAG_PASA_EL_LINK = "#pasaellink";
    private final String TAG_SIMPSONS = "#simpsons";
    private final String TAG_GULI = "#guli";
    private final String TAG_JALEA = "#jalea";
    private final String TAG_GRITO = "#grito";
    private final String TAG_VOZ_BOLUDO = "#vozboludo";
    private final String TAG_POIO = "#poio";
    private final String TAG_ROTISERIA = "#rotiseria";
    private final String TAG_COMAN_POIA = "#comanpoia";
    private final String TAG_NOO = "#noo";
    private final String TAG_CAGON = "#cagon";
    private final String TAG_VIRGOCHO = "#virgocho";
    private final String TAG_PUTACO = "#putaco";
    private final String TAG_CARAMIERDA = "#caramierda";
    private final String TAG_FH2 = "#fh2";
    private final String TAG_FEMINISTA = "#feminista";
    private final String TAG_AJIO = "#ajio";
    private final String TAG_VIENTO = "#viento";
    private final String TAG_HERRAIZ = "#herraiz";

    private final Tag OBJ_TAG_UBER = new Tag(TAG_UBER);
    private final Tag OBJ_TAG_FABRIO = new Tag(TAG_FABRIO);
    private final Tag OBJ_TAG_FIURI = new Tag(TAG_FIURI);
    private final Tag OBJ_TAG_MACREE = new Tag(TAG_MACREE);
    private final Tag OBJ_TAG_GOL = new Tag(TAG_GOL);
    private final Tag OBJ_TAG_RIVER = new Tag(TAG_RIVER);
    private final Tag OBJ_TAG_LUCHON = new Tag(TAG_LUCHON);
    private final Tag OBJ_TAG_PELOTUDO = new Tag(TAG_PELOTUDO);
    private final Tag OBJ_TAG_SONIDO = new Tag(TAG_SONIDO);
    private final Tag OBJ_TAG_SHIT_MUSIC = new Tag(TAG_SHIT_MUSIC);
    private final Tag OBJ_TAG_RISA = new Tag(TAG_RISA);
    private final Tag OBJ_TAG_ERUCTO = new Tag(TAG_ERUCTO);
    private final Tag OBJ_TAG_PEDO = new Tag(TAG_PEDO);
    private final Tag OBJ_TAG_LUACHA = new Tag(TAG_LUACHA);
    private final Tag OBJ_TAG_HIJO_DE_PUTA = new Tag(TAG_HIJO_DE_PUTA);
    private final Tag OBJ_TAG_SOCIALISMO = new Tag(TAG_SOCIALISMO);
    private final Tag OBJ_TAG_MARCE = new Tag(TAG_MARCE);
    private final Tag OBJ_TAG_PERO_MAS_BIEN = new Tag(TAG_PERO_MAS_BIEN);
    private final Tag OBJ_TAG_OSHTIAPUTA = new Tag(TAG_OSHTIAPUTA);
    private final Tag OBJ_TAG_SALUDO = new Tag(TAG_SALUDO);
    private final Tag OBJ_TAG_ESE_SOI_IO = new Tag(TAG_ESE_SOI_IO);
    private final Tag OBJ_TAG_RAMI = new Tag(TAG_RAMI);
    private final Tag OBJ_TAG_AH_PERO_ANOCHE = new Tag(TAG_AH_PERO_ANOCHE);
    private final Tag OBJ_TAG_YA_TE_RAJO = new Tag(TAG_YA_TE_RAJO);
    private final Tag OBJ_TAG_MANE = new Tag(TAG_MANE);
    private final Tag OBJ_TAG_GAJTAUN = new Tag(TAG_GAJTAUN);
    private final Tag OBJ_TAG_BLACK = new Tag(TAG_BLACK);
    private final Tag OBJ_TAG_KUKA = new Tag(TAG_KUKA);
    private final Tag OBJ_TAG_JODER = new Tag(TAG_JODER);
    private final Tag OBJ_TAG_EISH = new Tag(TAG_EISH);
    private final Tag OBJ_TAG_AY_QUE_RECO_MAME = new Tag(TAG_AY_QUE_RECO_MAME);
    private final Tag OBJ_TAG_NIGUIN = new Tag(TAG_NIGUIN);
    private final Tag OBJ_TAG_TREN = new Tag(TAG_TREN);
    private final Tag OBJ_TAG_BASTA_CHICOS = new Tag(TAG_BASTA_CHICOS);
    private final Tag OBJ_TAG_FORT = new Tag(TAG_FORT);
    private final Tag OBJ_TAG_PASA_EL_LINK = new Tag(TAG_PASA_EL_LINK);
    private final Tag OBJ_TAG_SIMPSONS = new Tag(TAG_SIMPSONS);
    private final Tag OBJ_TAG_GULI = new Tag(TAG_GULI);
    private final Tag OBJ_TAG_JALEA = new Tag(TAG_JALEA);
    private final Tag OBJ_TAG_GRITO = new Tag(TAG_GRITO);
    private final Tag OBJ_TAG_VOZ_BOLUDO = new Tag(TAG_VOZ_BOLUDO);
    private final Tag OBJ_TAG_POIO = new Tag(TAG_POIO);
    private final Tag OBJ_TAG_ROTISERIA = new Tag(TAG_ROTISERIA);
    private final Tag OBJ_TAG_COMAN_POIA = new Tag(TAG_COMAN_POIA);
    private final Tag OBJ_TAG_NOO = new Tag(TAG_NOO);
    private final Tag OBJ_TAG_CAGON = new Tag(TAG_CAGON);
    private final Tag OBJ_TAG_VIRGOCHO = new Tag(TAG_VIRGOCHO);
    private final Tag OBJ_TAG_PUTACO = new Tag(TAG_PUTACO);
    private final Tag OBJ_TAG_CARAMIERDA = new Tag(TAG_CARAMIERDA);
    private final Tag OBJ_TAG_FH2 = new Tag(TAG_FH2);
    private final Tag OBJ_TAG_FEMINISTA = new Tag(TAG_FEMINISTA);
    private final Tag OBJ_TAG_AJIO = new Tag(TAG_AJIO);
    private final Tag OBJ_TAG_VIENTO = new Tag(TAG_VIENTO);
    private final Tag OBJ_TAG_HERRAIZ = new Tag(TAG_HERRAIZ);

    public List<String> getTags() {

        List<String> tags = Arrays.asList(
                TAG_UBER,
                TAG_FABRIO,
                TAG_FIURI,
                TAG_MACREE,
                TAG_GOL,
                TAG_RIVER,
                TAG_LUCHON,
                TAG_PELOTUDO,
                TAG_SONIDO,
                TAG_SHIT_MUSIC,
                TAG_RISA,
                TAG_ERUCTO,
                TAG_PEDO,
                TAG_LUACHA,
                TAG_HIJO_DE_PUTA,
                TAG_SOCIALISMO,
                TAG_MARCE,
                TAG_PERO_MAS_BIEN,
                TAG_OSHTIAPUTA,
                TAG_SALUDO,
                TAG_ESE_SOI_IO,
                TAG_RAMI,
                TAG_AH_PERO_ANOCHE,
                TAG_YA_TE_RAJO,
                TAG_MANE,
                TAG_GAJTAUN,
                TAG_BLACK,
                TAG_KUKA,
                TAG_JODER,
                TAG_EISH,
                TAG_AY_QUE_RECO_MAME,
                TAG_NIGUIN,
                TAG_TREN,
                TAG_BASTA_CHICOS,
                TAG_FORT,
                TAG_PASA_EL_LINK,
                TAG_SIMPSONS,
                TAG_GULI,
                TAG_JALEA,
                TAG_GRITO,
                TAG_VOZ_BOLUDO,
                TAG_POIO,
                TAG_ROTISERIA,
                TAG_COMAN_POIA,
                TAG_NOO,
                TAG_CAGON,
                TAG_VIRGOCHO,
                TAG_PUTACO,
                TAG_CARAMIERDA,
                TAG_FH2,
                TAG_FEMINISTA
        );

        Collections.sort(tags);
        return tags;
    }

    public List<Audio> getAudios() {

        return Arrays.asList(
                new Audio(R.raw.audio_1, "Te voy a tocar la jalea", Arrays.asList(
                        OBJ_TAG_UBER,
                        OBJ_TAG_JALEA
                )),
                new Audio(R.raw.audio_2, "No pichu noo!", Arrays.asList(
                        OBJ_TAG_LUACHA,
                        OBJ_TAG_GRITO,
                        OBJ_TAG_NOO
                )),
                new Audio(R.raw.audio_3, "Ay que reco mamee", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_AY_QUE_RECO_MAME
                )),
                new Audio(R.raw.audio_4,
                        "Pero por qué hace esa voz de boludooo",
                        Arrays.asList(
                                OBJ_TAG_LUACHA,
                                OBJ_TAG_VOZ_BOLUDO
                        )),
                new Audio(R.raw.audio_5, "Poioooo", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_POIO,
                        OBJ_TAG_SALUDO
                )),
                new Audio(R.raw.audio_6, "Uy mira ese guli que lendoo", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_7, "Heee por qué me decis eso?", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_8, "Hola si rotiseria?", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_ROTISERIA
                )),
                new Audio(R.raw.audio_9, "Ay que reco mameee (2)", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_AY_QUE_RECO_MAME
                )),
                new Audio(R.raw.audio_10,
                        "Te lo dije a vos? a mi me parece que no",
                        Arrays.asList(
                                OBJ_TAG_UBER
                        )),
                new Audio(R.raw.audio_11,
                        "Ya mismo estoy entrando a la pagina",
                        Arrays.asList(
                                OBJ_TAG_GAJTAUN
                        )),
                new Audio(R.raw.audio_12, "Coman poiaa", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_COMAN_POIA
                )),
                new Audio(R.raw.audio_13, "Nooo", Arrays.asList(
                        OBJ_TAG_GAJTAUN,
                        OBJ_TAG_NOO
                )),
                new Audio(R.raw.audio_14, "NOOOO", Arrays.asList(
                        OBJ_TAG_GAJTAUN,
                        OBJ_TAG_NOO
                )),
                new Audio(R.raw.audio_15,
                        "Lo vas a borrar porque sos asi cagoon",
                        Arrays.asList(
                                OBJ_TAG_GAJTAUN,
                                OBJ_TAG_CAGON
                        )),
                new Audio(R.raw.audio_16, "Caramierda...", Arrays.asList(
                        OBJ_TAG_LUACHA,
                        OBJ_TAG_CARAMIERDA
                )),
                new Audio(R.raw.audio_17, "Cosa de hombres carajo", Arrays.asList(
                        OBJ_TAG_UBER
                )),
                new Audio(R.raw.audio_18,
                        "Para loco, pensa en nosotros, en los pibes",
                        Arrays.asList(
                                OBJ_TAG_UBER
                        )),
                new Audio(R.raw.audio_19, "Salio alto dia de forgotteeen", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_FH2
                )),
                new Audio(R.raw.audio_20, "Ay que reco mamee (3)", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_AY_QUE_RECO_MAME
                )),
                new Audio(R.raw.audio_21, "Ay que reco mamee (4)", Arrays.asList(
                        OBJ_TAG_GULI,
                        OBJ_TAG_AY_QUE_RECO_MAME
                )),
                new Audio(R.raw.audio_22, "Ay que lindo manee", Arrays.asList(
                        OBJ_TAG_GULI
                )),
                new Audio(R.raw.audio_23, "Ay que reco mamee (5)", Arrays.asList(
                        OBJ_TAG_GAJTAUN,
                        OBJ_TAG_AY_QUE_RECO_MAME
                )),
                new Audio(R.raw.audio_24, "Un heroe, un heroee", Arrays.asList(
                        OBJ_TAG_GAJTAUN,
                        OBJ_TAG_NIGUIN
                )),
                new Audio(R.raw.audio_25, "Que borras", Arrays.asList(
                        OBJ_TAG_UBER,
                        OBJ_TAG_CAGON
                )),
                new Audio(R.raw.audio_26, "Mírenlo.. el putaco", Arrays.asList(
                        OBJ_TAG_UBER,
                        OBJ_TAG_CAGON,
                        OBJ_TAG_PUTACO
                )),
                new Audio(R.raw.audio_27, "Ese virgocho soi io", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_VIRGOCHO,
                        OBJ_TAG_ESE_SOI_IO
                )),
                new Audio(R.raw.audio_28, "Creo que estoy ciego...", Arrays.asList(
                        OBJ_TAG_NIGUIN
                )),
                new Audio(R.raw.audio_29, "Vos no sos de fiar, cabronazo", Arrays.asList(
                        OBJ_TAG_LUACHA
                )),
                new Audio(R.raw.audio_30, "Ay que reco mamee (6)", Arrays.asList(
                        OBJ_TAG_GAJTAUN,
                        OBJ_TAG_AY_QUE_RECO_MAME
                )),
                new Audio(R.raw.audio_31,
                        "Alto ñoqui kirchnerista sos viste...",
                        Arrays.asList(
                                OBJ_TAG_BLACK,
                                OBJ_TAG_KUKA
                        )),
                new Audio(R.raw.audio_32,
                        "Que vas a ser fachero, sos un ñoqui de mier...",
                        Arrays.asList(
                                OBJ_TAG_BLACK,
                                OBJ_TAG_KUKA
                        )),
                new Audio(R.raw.audio_33, "JO-DER", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_JODER
                )),
                new Audio(R.raw.audio_34, "Siii io doy todo mi amor", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_35, "Mirá como estan esas nuvecitaas", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_36,
                        "Ay nene, por fin una foto no mochista",
                        Arrays.asList(
                                OBJ_TAG_UBER,
                                OBJ_TAG_FEMINISTA
                        )),
                new Audio(R.raw.audio_37,
                        "Que me digiste gil? TE VOY A PARTIR LA CABEZA!",
                        Arrays.asList(
                                OBJ_TAG_UBER
                        )),
                new Audio(R.raw.audio_38,
                        "Hace 20 años que no voy a uno de esos",
                        Arrays.asList(
                                OBJ_TAG_MARCE
                        )),
                new Audio(R.raw.audio_39,
                        "Che capaz que en media hora estoy, van a estar?",
                        Arrays.asList(
                                OBJ_TAG_MARCE,
                                OBJ_TAG_FH2
                        )),
                new Audio(R.raw.audio_40, "Si papa veni por favoor", Arrays.asList(
                        OBJ_TAG_NIGUIN
                )),
                new Audio(R.raw.audio_41, "Se fue poio esta muerto", Arrays.asList(
                        OBJ_TAG_NIGUIN
                )),
                new Audio(R.raw.audio_42, "Ah ok..", Arrays.asList(
                        OBJ_TAG_UBER
                )),
                new Audio(R.raw.audio_43, "* Sonido de pedo *", Arrays.asList(
                        OBJ_TAG_PEDO,
                        OBJ_TAG_SONIDO
                )),
                new Audio(R.raw.audio_44, "Ja ja ja, que buen chiste", Arrays.asList(
                        OBJ_TAG_GAJTAUN
                )),
                new Audio(R.raw.audio_45,
                        "Que pasa aca, no se puede mandar fotod de mujeres desnudas",
                        Arrays.asList(
                                OBJ_TAG_GAJTAUN
                        )),
                new Audio(R.raw.audio_46, "Ah listo, ya te rajo", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_YA_TE_RAJO
                )),
                new Audio(R.raw.audio_47, "Cuentenme algo, me aburro", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_48, "No tuvo ni puta gracia guli", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_49, "Ubeeer", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_SALUDO
                )),
                new Audio(R.raw.audio_50,
                        "Puede ser algo que comiste que te partió la boca",
                        Arrays.asList(
                                OBJ_TAG_UBER
                        )),
                new Audio(R.raw.audio_51, "* PAC PAC PAC PAC *", Arrays.asList(
                        OBJ_TAG_SONIDO
                )),
                new Audio(R.raw.audio_52, "Pechuleeeen", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_SALUDO
                )),
                new Audio(R.raw.audio_53, "PECHULEEEEEEN", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_SALUDO
                )),
                new Audio(R.raw.audio_54, "Ah pero anoche...", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_AH_PERO_ANOCHE
                )),
                new Audio(R.raw.audio_55, "Che buen tipo este pedro eh...", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_56, "Ecualam", Arrays.asList(
                        OBJ_TAG_GAJTAUN,
                        OBJ_TAG_EISH
                )),
                new Audio(R.raw.audio_57, "Ay que reco mamee (7)", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_AY_QUE_RECO_MAME
                )),
                new Audio(R.raw.audio_58, "Maneeee", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_SALUDO
                )),
                new Audio(R.raw.audio_59, "Gastoncilloooo mi amol", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_SALUDO
                )),
                new Audio(R.raw.audio_60, "Jodeeeeer", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_JODER
                )),
                new Audio(R.raw.audio_61, "Dicimula la envidia pollooo", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_62, "Hola si rotiseria? (2)", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_ROTISERIA
                )),
                new Audio(R.raw.audio_63, "Ay que reco mamee (8)", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_AY_QUE_RECO_MAME
                )),
                new Audio(R.raw.audio_64, "PECHULEEEEEEN (2)", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_SALUDO
                )),
                new Audio(R.raw.audio_65, "PECHULEEEEEEN (3)", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_SALUDO
                )),
                new Audio(R.raw.audio_66,
                        "Che cuentenme algo, hijos de mil putas",
                        Arrays.asList(
                                OBJ_TAG_MARCE,
                                OBJ_TAG_HIJO_DE_PUTA
                        )),
                new Audio(R.raw.audio_67,
                        "Al carajo, al carajo, que se vayan al carajo",
                        Arrays.asList(
                                OBJ_TAG_MARCE
                        )),
                new Audio(R.raw.audio_68, "Haaaa....", Arrays.asList(
                        OBJ_TAG_NIGUIN
                )),
                new Audio(R.raw.audio_69, "Ay que rico", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_AY_QUE_RECO_MAME
                )),
                new Audio(R.raw.audio_70, "Terrible masacre..", Arrays.asList(
                        OBJ_TAG_RAMI
                )),
                new Audio(R.raw.audio_71, "Ese culiado soi io", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_ESE_SOI_IO
                )),
                new Audio(R.raw.audio_72,
                        "Ha pero cuando la invitas a la campaña..",
                        Arrays.asList(
                                OBJ_TAG_MARCE,
                                OBJ_TAG_AH_PERO_ANOCHE
                        )),
                new Audio(R.raw.audio_73, "Ay que reco mamee (9)", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_AY_QUE_RECO_MAME
                )),
                new Audio(R.raw.audio_74,
                        "Hola si, tengo una llamada para pollo del 2007..",
                        Arrays.asList(
                                OBJ_TAG_UBER,
                                OBJ_TAG_PELOTUDO
                        )),
                new Audio(R.raw.audio_75, "Invitalaaa sé luchón", Arrays.asList(
                        OBJ_TAG_FABRIO,
                        OBJ_TAG_LUCHON
                )),
                new Audio(R.raw.audio_76,
                        "Escucha, escucha * PAC PAC PAC *",
                        Arrays.asList(
                                OBJ_TAG_LUACHA,
                                OBJ_TAG_SONIDO
                        )),
                new Audio(R.raw.audio_77, "Son un asco loco", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_78, "Eeeeeel trabajadooooor", Arrays.asList(
                        OBJ_TAG_FABRIO
                )),
                new Audio(R.raw.audio_79, "Estas re lindo uber..", Arrays.asList(
                        OBJ_TAG_GAJTAUN
                )),
                new Audio(R.raw.audio_80, "Furiiiii, caramierda", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_SALUDO
                )),
                new Audio(R.raw.audio_81, "Holaaaa", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_SALUDO
                )),
                new Audio(R.raw.audio_82,
                        "Gracias uber... el unico quie banco de todo este puto grupo!",
                        Arrays.asList(
                                OBJ_TAG_MARCE
                        )),
                new Audio(R.raw.audio_83, "PECHULEEEEEEN (4)", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_SALUDO
                )),
                new Audio(R.raw.audio_84, "JODEEEEEER (2)", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_JODER
                )),
                new Audio(R.raw.audio_85, "PECHULEEEEEEN (5)", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_SALUDO
                )),
                new Audio(R.raw.audio_86, "Ay que reco mameee", Arrays.asList(
                        OBJ_TAG_UBER,
                        OBJ_TAG_AY_QUE_RECO_MAME
                )),
                new Audio(R.raw.audio_87, "Ay que reco mameee", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_AY_QUE_RECO_MAME
                )),
                new Audio(R.raw.audio_88,
                        "Para, para no me asustes boludo, eso puede pasar?",
                        Arrays.asList(
                                OBJ_TAG_LUACHA
                        )),
                new Audio(R.raw.audio_89, "Uy la puta madre, cague...", Arrays.asList(
                        OBJ_TAG_LUACHA
                )),
                new Audio(R.raw.audio_90, "* Eructo*", Arrays.asList(
                        OBJ_TAG_SONIDO,
                        OBJ_TAG_ERUCTO
                )),
                new Audio(R.raw.audio_91,
                        "Me cago en dios y lña puta madre que los parió",
                        Arrays.asList(
                                OBJ_TAG_SONIDO,
                                OBJ_TAG_MARCE
                        )),
                new Audio(R.raw.audio_92, "PECHULEEEEEEN (6)", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_SALUDO
                )),
                new Audio(R.raw.audio_93, "Ay que reco mameee (2)", Arrays.asList(
                        OBJ_TAG_UBER,
                        OBJ_TAG_AY_QUE_RECO_MAME
                )),
                new Audio(R.raw.audio_94, "Ay que reco mameee (2)", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_AY_QUE_RECO_MAME
                )),
                new Audio(R.raw.audio_95, "Coman poiaaa", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_COMAN_POIA
                )),
                new Audio(R.raw.audio_96, "Hola si rotiseria?", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_ROTISERIA
                )),
                new Audio(R.raw.audio_97, "Fabriiiii", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_SALUDO
                )),
                new Audio(R.raw.audio_98, "Que te pasa cabeza de culo?", Arrays.asList(
                        OBJ_TAG_UBER
                )),
                new Audio(R.raw.audio_99,
                        "Pero no me faltes el respeto loco",
                        Arrays.asList(
                                OBJ_TAG_UBER
                        )),
                new Audio(R.raw.audio_100, "Maneee", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_SALUDO
                )),
                new Audio(R.raw.audio_101,
                        "Dale mane, no intentes decir que tu vida es una puta mierda...",
                        Arrays.asList(
                                OBJ_TAG_MARCE
                        )),
                new Audio(R.raw.audio_102, "Ay pero que emoción", Arrays.asList(
                        OBJ_TAG_GULI
                )),
                new Audio(R.raw.audio_103,
                        "Que no ostia, ya dije que es una amiga",
                        Arrays.asList(
                                OBJ_TAG_MARCE,
                                OBJ_TAG_OSHTIAPUTA
                        )),
                new Audio(R.raw.audio_104, "Ay que rico furi", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_AY_QUE_RECO_MAME
                )),
                new Audio(R.raw.audio_105,
                        "No se confundan, no pague por eso",
                        Arrays.asList(
                                OBJ_TAG_MARCE,
                                OBJ_TAG_AY_QUE_RECO_MAME
                        )),
                new Audio(R.raw.audio_106, "Aguante river iiiijiji!", Arrays.asList(
                        OBJ_TAG_FABRIO,
                        OBJ_TAG_RIVER
                )),
                new Audio(R.raw.audio_107, "Dejense de mierdas, ostias", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_OSHTIAPUTA
                )),
                new Audio(R.raw.audio_108, "Poiooooooo (2)", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_SALUDO
                )),
                new Audio(R.raw.audio_109, "PECHULEEEEEEN (7)", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_SALUDO
                )),
                new Audio(R.raw.audio_110, "Holiiiii", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_SALUDO
                )),
                new Audio(R.raw.audio_111, "Pedritoooo", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_SALUDO
                )),
                new Audio(R.raw.audio_112, "Coman poiaaaa", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_COMAN_POIA
                )),
                new Audio(R.raw.audio_113, "Pero mas bien loquita", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_PERO_MAS_BIEN
                )),
                new Audio(R.raw.audio_114, "No toquen las bolas loco", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_115, "Y io lo amo", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_116,
                        "Que te haces el protagonista hijo de puta",
                        Arrays.asList(
                                OBJ_TAG_MARCE,
                                OBJ_TAG_HIJO_DE_PUTA
                        )),
                new Audio(R.raw.audio_117, "Se olle bieeen", Arrays.asList(
                        OBJ_TAG_NIGUIN
                )),
                new Audio(R.raw.audio_118,
                        "Pero veni y decimelo en la cara pelotudo",
                        Arrays.asList(
                                OBJ_TAG_LUACHA
                        )),
                new Audio(R.raw.audio_119, "jajaja que hijo de puta", Arrays.asList(
                        OBJ_TAG_FABRIO,
                        OBJ_TAG_HIJO_DE_PUTA
                )),
                new Audio(R.raw.audio_120, "Gooool mierdaa", Arrays.asList(
                        OBJ_TAG_FABRIO,
                        OBJ_TAG_GOL
                )),
                new Audio(R.raw.audio_121, "Ah pero anocheee", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_AH_PERO_ANOCHE
                )),
                new Audio(R.raw.audio_122, "Nooooooooo....", Arrays.asList(
                        OBJ_TAG_LUACHA,
                        OBJ_TAG_NOO
                )),
                new Audio(R.raw.audio_123, "Cojermela ahora mismo dudud..", Arrays.asList(
                        OBJ_TAG_NIGUIN,
                        OBJ_TAG_SIMPSONS
                )),
                new Audio(R.raw.audio_124, "Ay que recoooooo", Arrays.asList(
                        OBJ_TAG_NIGUIN,
                        OBJ_TAG_AY_QUE_RECO_MAME
                )),
                new Audio(R.raw.audio_125, "Pasame el link", Arrays.asList(
                        OBJ_TAG_NIGUIN,
                        OBJ_TAG_PASA_EL_LINK
                )),
                new Audio(R.raw.audio_126, "Jajaja es moy bueno", Arrays.asList(
                        OBJ_TAG_NIGUIN
                )),
                new Audio(R.raw.audio_127,
                        "La recalcada concha de tu hermana macri",
                        Arrays.asList(
                                OBJ_TAG_FABRIO,
                                OBJ_TAG_MACREE
                        )),
                new Audio(R.raw.audio_128,
                        "Eh no, no no, mane pasa mas memes",
                        Arrays.asList(
                                OBJ_TAG_UBER
                        )),
                new Audio(R.raw.audio_129, "Basta chicos", Arrays.asList(
                        OBJ_TAG_NIGUIN,
                        OBJ_TAG_BASTA_CHICOS,
                        OBJ_TAG_FORT
                )),
                new Audio(R.raw.audio_130, "PECHULEEEEEEN (8)", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_SALUDO
                )),
                new Audio(R.raw.audio_131, "PECHULEEEEEEN (9)", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_SALUDO
                )),
                new Audio(R.raw.audio_132, "Poiooooooo (3)", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_SALUDO
                )),
                new Audio(R.raw.audio_133,
                        "Sos un hijo de puta pocho, sos un hijo de puta!",
                        Arrays.asList(
                                OBJ_TAG_MARCE,
                                OBJ_TAG_HIJO_DE_PUTA
                        )),
                new Audio(R.raw.audio_134, "Es MUY mane", Arrays.asList(
                        OBJ_TAG_LUACHA
                )),
                new Audio(R.raw.audio_135, "JO-DER", Arrays.asList(
                        OBJ_TAG_LUACHA,
                        OBJ_TAG_JODER
                )),
                new Audio(R.raw.audio_136,
                        "Ya no sabe mas que boludez inventar este",
                        Arrays.asList(
                                OBJ_TAG_LUACHA
                        )),
                new Audio(R.raw.audio_137,
                        "Bueno eso ya es un punto a favor tuyo",
                        Arrays.asList(
                                OBJ_TAG_NIGUIN
                        )),
                new Audio(R.raw.audio_138, "* Llorando *", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_SONIDO
                )),
                new Audio(R.raw.audio_139, "PECHULEEEEEEN (10)", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_SALUDO
                )),
                new Audio(R.raw.audio_140, "Voy a ver que gil!", Arrays.asList(
                        OBJ_TAG_MANE
                )),
                new Audio(R.raw.audio_141, "PECHULEEEEEEN (11)", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_SALUDO
                )),
                new Audio(R.raw.audio_142, "Te tiene mal el socialismo", Arrays.asList(
                        OBJ_TAG_LUACHA,
                        OBJ_TAG_SOCIALISMO
                )),
                new Audio(R.raw.audio_143, "Sos un hijo de puta", Arrays.asList(
                        OBJ_TAG_LUACHA,
                        OBJ_TAG_HIJO_DE_PUTA
                )),
                new Audio(R.raw.audio_144,
                        "Guliiiiiiiiiiiiiiiiiiiiiiiiii...",
                        Arrays.asList(
                                OBJ_TAG_LUACHA
                        )),
                new Audio(R.raw.audio_145, "Que onda furiii", Arrays.asList(
                        OBJ_TAG_GAJTAUN,
                        OBJ_TAG_SALUDO
                )),
                new Audio(R.raw.audio_146, "La podes cortar flaco?", Arrays.asList(
                        OBJ_TAG_FIURI
                )),
                new Audio(R.raw.audio_147,
                        "Consulta al doctor, yo soy enfermero",
                        Arrays.asList(
                                OBJ_TAG_UBER
                        )),
                new Audio(R.raw.audio_148, "JAJA AJAJAJA AJAJA AJAJ", Arrays.asList(
                        OBJ_TAG_UBER,
                        OBJ_TAG_SONIDO,
                        OBJ_TAG_RISA
                )),
                new Audio(R.raw.audio_149,
                        "Bueno hijo de puta, no me sale, que uqeres que haga",
                        Arrays.asList(
                                OBJ_TAG_LUACHA,
                                OBJ_TAG_HIJO_DE_PUTA
                        )),
                new Audio(R.raw.audio_150,
                        "No podes preguntar algo asi en este grupo de mierda",
                        Arrays.asList(
                                OBJ_TAG_LUACHA
                        )),
                new Audio(R.raw.audio_151,
                        "Que te pasa con mane facho hijo de mil putas?",
                        Arrays.asList(
                                OBJ_TAG_UBER,
                                OBJ_TAG_HIJO_DE_PUTA
                        )),
                new Audio(R.raw.audio_152,
                        "Si, este, rompo culos tambien a domicilio",
                        Arrays.asList(
                                OBJ_TAG_UBER
                        )),
                new Audio(R.raw.audio_153, "Es muy facil", Arrays.asList(
                        OBJ_TAG_LUACHA
                )),
                new Audio(R.raw.audio_154, "No es todo lo mismo eso?", Arrays.asList(
                        OBJ_TAG_LUACHA
                )),
                new Audio(R.raw.audio_155,
                        "Los alemanes nos atacaron anoche repetidas veces",
                        Arrays.asList(
                                OBJ_TAG_GAJTAUN,
                                OBJ_TAG_FH2
                        )),
                new Audio(R.raw.audio_156, "HIJO-DE-PUTA...", Arrays.asList(
                        OBJ_TAG_LUACHA,
                        OBJ_TAG_HIJO_DE_PUTA
                )),
                new Audio(R.raw.audio_157, "Haaawwwww... que tierno...", Arrays.asList(
                        OBJ_TAG_GAJTAUN
                )),
                new Audio(R.raw.audio_158, "A mi se me hace que sos marica", Arrays.asList(
                        OBJ_TAG_NIGUIN
                )),
                new Audio(R.raw.audio_159, "Ay que reco mamee (43)", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_AY_QUE_RECO_MAME
                )),
                new Audio(R.raw.audio_160, "PECHULEEEEEEN (12)", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_SALUDO
                )),
                new Audio(R.raw.audio_161, "Ha si?.. bueno tu hermana", Arrays.asList(
                        OBJ_TAG_UBER
                )),
                new Audio(R.raw.audio_162, "Cuere que cuere... pum pum..♫", Arrays.asList(
                        OBJ_TAG_UBER,
                        OBJ_TAG_SONIDO
                )),
                new Audio(R.raw.audio_163, "Gajtaaaaaaaaaun", Arrays.asList(
                        OBJ_TAG_LUACHA,
                        OBJ_TAG_SALUDO
                )),
                new Audio(R.raw.audio_164, "Buenos díaaaaaaaaaaas", Arrays.asList(
                        OBJ_TAG_NIGUIN,
                        OBJ_TAG_SALUDO
                )),
                new Audio(R.raw.audio_165, "Ah no? y yo que soy", Arrays.asList(
                        OBJ_TAG_LUACHA
                )),
                new Audio(R.raw.audio_166,
                        "Ay todas esas drogas, quisiera tener ahora mismo una dududu..",
                        Arrays.asList(
                                OBJ_TAG_NIGUIN,
                                OBJ_TAG_SIMPSONS
                        )),
                new Audio(R.raw.audio_167,
                        "Chicles beldent, chicles beldent...",
                        Arrays.asList(
                                OBJ_TAG_GAJTAUN,
                                OBJ_TAG_TREN
                        )),
                new Audio(R.raw.audio_168,
                        "Chicles beldent, chicles beldent... (2)",
                        Arrays.asList(
                                OBJ_TAG_GAJTAUN,
                                OBJ_TAG_TREN
                        )),
                new Audio(R.raw.audio_169, "Se te hizo agua la boca cogote", Arrays.asList(
                        OBJ_TAG_GAJTAUN
                )),
                new Audio(R.raw.audio_170, "* Sonido de pedo (2) *", Arrays.asList(
                        OBJ_TAG_PEDO,
                        OBJ_TAG_SONIDO
                )),
                new Audio(R.raw.audio_171, "Estaba haciendo nonita?", Arrays.asList(
                        OBJ_TAG_NIGUIN
                )),
                new Audio(R.raw.audio_172, "Salí de ahi ya oshtia", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_OSHTIAPUTA
                )),
                new Audio(R.raw.audio_173, "Joder", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_JODER
                )),
                new Audio(R.raw.audio_174,
                        "Mira como esta esa rapada viejaa",
                        Arrays.asList(
                                OBJ_TAG_MARCE,
                                OBJ_TAG_JODER
                        )),
                new Audio(R.raw.audio_175, "* Sonido de pedo (3) *", Arrays.asList(
                        OBJ_TAG_PEDO,
                        OBJ_TAG_SONIDO
                )),
                new Audio(R.raw.audio_176, "* Sonido de pedo (4) *", Arrays.asList(
                        OBJ_TAG_PEDO,
                        OBJ_TAG_SONIDO
                )),
                new Audio(R.raw.audio_177,
                        "Por que eliminaste ese mensaje?",
                        Arrays.asList(
                                OBJ_TAG_LUACHA,
                                OBJ_TAG_CAGON
                        )),
                new Audio(R.raw.audio_178,
                        "Hijo de puta, que vas a cocinar",
                        Arrays.asList(
                                OBJ_TAG_NIGUIN
                        )),
                new Audio(R.raw.audio_179,
                        "El hombre mira al hombreeee... y le aguanta la mirada",
                        Arrays.asList(
                                OBJ_TAG_GAJTAUN,
                                OBJ_TAG_SONIDO,
                                OBJ_TAG_SHIT_MUSIC
                        )),
                new Audio(R.raw.audio_180, "Mandale saludos", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_SALUDO
                )),
                new Audio(R.raw.audio_181, "Che poio hay quilombo eh", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_182,
                        "Hicieron trampa pocho, hicieron trampa!",
                        Arrays.asList(
                                OBJ_TAG_MARCE
                        )),
                new Audio(R.raw.audio_183, "Fabri de mi vidaa", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_184, "PICHULEEEEEEN (13)", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_SALUDO
                )),
                new Audio(R.raw.audio_185,
                        "Que haces despierto vos a esta hora?",
                        Arrays.asList(
                                OBJ_TAG_FABRIO
                        )),
                new Audio(R.raw.audio_186, "Es sabado vieja", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_187, "Pero mirá ese deportista papá", Arrays.asList(
                        OBJ_TAG_FABRIO
                )),
                new Audio(R.raw.audio_188, "Puta madreee", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_HIJO_DE_PUTA
                )),
                new Audio(R.raw.audio_189, "* Pac pac pac pac pac *", Arrays.asList(
                        OBJ_TAG_SONIDO
                )),
                new Audio(R.raw.audio_190, "Te voy a matar hijo de tu madre adrgradrgala", Arrays.asList(
                        OBJ_TAG_LUACHA,
                        OBJ_TAG_HIJO_DE_PUTA
                )),
                new Audio(R.raw.audio_191, "Que sea la última vez que cometes ese error...engendro", Arrays.asList(
                        OBJ_TAG_UBER
                )),
                new Audio(R.raw.audio_192, "Pedón pod ed detdsaso", Arrays.asList(
                        OBJ_TAG_UBER
                )),
                new Audio(R.raw.audio_193, "Eso te pasa por boludo", Arrays.asList(
                        OBJ_TAG_LUACHA
                )),
                new Audio(R.raw.audio_194, "Mida voz loco... midá que intedezante", Arrays.asList(
                        OBJ_TAG_UBER
                )),
                new Audio(R.raw.audio_195, "La acaban de pasar capo...", Arrays.asList(
                        OBJ_TAG_FIURI
                )),
                new Audio(R.raw.audio_196, "Jua jua jua jua", Arrays.asList(
                        OBJ_TAG_LUACHA,
                        OBJ_TAG_RISA
                )),
                new Audio(R.raw.audio_197, "Ha...bueno dejame decirte que FFFFFFFFFSSSSSHHHHHHH", Arrays.asList(
                        OBJ_TAG_UBER,
                        OBJ_TAG_VIENTO
                )),
                new Audio(R.raw.audio_198, "Entiendo...si, entiendo....FFFFFFFFSSSSSHHHHHHH", Arrays.asList(
                        OBJ_TAG_UBER,
                        OBJ_TAG_VIENTO
                )),

                new Audio(R.raw.audio_199, "Che, a ver si se dejan de romper las pelotas que quiero dormir....FFFFFFFFSSSSSHHHHHHH", Arrays.asList(
                        OBJ_TAG_GAJTAUN,
                        OBJ_TAG_VIENTO
                )),
                new Audio(R.raw.audio_200, "Holaaa", Arrays.asList(
                        OBJ_TAG_MACREE,
                        OBJ_TAG_SALUDO
                )),
                new Audio(R.raw.audio_201, "Mane puto", Arrays.asList(
                        OBJ_TAG_FIURI
                )),
                new Audio(R.raw.audio_202, "Ay que rico mameeee", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_AY_QUE_RECO_MAME
                )),
                new Audio(R.raw.audio_203, "Tengo un viejo verde que lo traigo frito \uD83C\uDFB5...", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_AY_QUE_RECO_MAME
                )),
                new Audio(R.raw.audio_204, "Que decis hijo de puta?...", Arrays.asList(
                        OBJ_TAG_LUACHA,
                        OBJ_TAG_HIJO_DE_PUTA
                )),
                new Audio(R.raw.audio_205, "Sos cagooon, de la patru de ombustmaaaan...", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_CAGON
                )),
                new Audio(R.raw.audio_206, "Ajio ajio ajio ajio...", Arrays.asList(
                        OBJ_TAG_GAJTAUN,
                        OBJ_TAG_AJIO
                )),
                new Audio(R.raw.audio_207, "Ah, ok....FFFFFFFFSSSSSHHHHHHH", Arrays.asList(
                        OBJ_TAG_UBER,
                        OBJ_TAG_VIENTO
                )),
                new Audio(R.raw.audio_208, "Su señoria, acaso es esta la cara y el perfil de un asesino?", Arrays.asList(
                        OBJ_TAG_UBER
                )),
                new Audio(R.raw.audio_209, "Y por culpa del capitalismo, por supuesto", Arrays.asList(
                        OBJ_TAG_LUACHA
                )),
                new Audio(R.raw.audio_210, "Ehh no, no.....FFFFFFFFSSSSSHHHHHHH", Arrays.asList(
                        OBJ_TAG_GAJTAUN,
                        OBJ_TAG_VIENTO
                )),
                new Audio(R.raw.audio_211, "* Sonido fury delfín *", Arrays.asList(
                        OBJ_TAG_FIURI,
                        OBJ_TAG_SONIDO
                )),
                new Audio(R.raw.audio_212, "Dale pelotudo", Arrays.asList(
                        OBJ_TAG_NIGUIN,
                        OBJ_TAG_PELOTUDO
                )),
                new Audio(R.raw.audio_213, "Un enfermo este pibe loco, mal", Arrays.asList(
                        OBJ_TAG_NIGUIN
                )),
                new Audio(R.raw.audio_214, "Quién entrtega el ojete", Arrays.asList(
                        OBJ_TAG_UBER
                )),
                new Audio(R.raw.audio_215, "Si, yo le pegué, yo le agredío, que van a hacer al respecto, EEHH?", Arrays.asList(
                        OBJ_TAG_UBER
                )),
                new Audio(R.raw.audio_216, "ajajá...borra eso estúpido", Arrays.asList(
                        OBJ_TAG_UBER
                )),
                new Audio(R.raw.audio_217, "Me perdonas?", Arrays.asList(
                        OBJ_TAG_LUACHA
                )),
                new Audio(R.raw.audio_218, "Si loco no no, no es gracioso, ya era...FFFFFFFFSSSSSHHHHHHH?", Arrays.asList(
                        OBJ_TAG_UBER,
                        OBJ_TAG_VIENTO
                )),
                new Audio(R.raw.audio_219, "Hijo de puta", Arrays.asList(
                        OBJ_TAG_NIGUIN,
                        OBJ_TAG_HIJO_DE_PUTA
                )),
                new Audio(R.raw.audio_220, "Paraa..para un poco..", Arrays.asList(
                        OBJ_TAG_UBER
                )),
                new Audio(R.raw.audio_221, "Mat...la puta madre", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_222, "Cuanta mierda contaron, pero la puta madre", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_223, "Y bien, me vas a decir que no te gustó hijo de puta?", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_HIJO_DE_PUTA
                )),
                new Audio(R.raw.audio_224, "Por qué me persigue la desgracia?", Arrays.asList(
                        OBJ_TAG_UBER,
                        OBJ_TAG_SIMPSONS
                )),
                new Audio(R.raw.audio_225, "Vamos a la cama que hay que descansar \uD83C\uDFB5...", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_226, "Se te nota la envidia, disiomula papu", Arrays.asList(
                        OBJ_TAG_UBER
                )),
                new Audio(R.raw.audio_227, "Hace frioooo lgdadada", Arrays.asList(
                        OBJ_TAG_LUACHA
                )),
                new Audio(R.raw.audio_228, "A tu médico no le podes hablar así, maleducado de mierda", Arrays.asList(
                        OBJ_TAG_UBER
                )),
                new Audio(R.raw.audio_229, "ja ja, saludFFFFFFFFSSSSSHHHHHHH", Arrays.asList(
                        OBJ_TAG_GAJTAUN,
                        OBJ_TAG_VIENTO
                )),
                new Audio(R.raw.audio_230, "Bien ahí hijo de puta", Arrays.asList(
                        OBJ_TAG_FABRIO,
                        OBJ_TAG_HIJO_DE_PUTA
                )),
                new Audio(R.raw.audio_231, "Aguante viejaaaaaa!", Arrays.asList(
                        OBJ_TAG_FABRIO
                )),
                new Audio(R.raw.audio_232, "Coman pollaaaaaaaa!", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_233, "Ah, que hijo de re mil putas que son", Arrays.asList(
                        OBJ_TAG_FABRIO,
                        OBJ_TAG_HIJO_DE_PUTA
                )),
                new Audio(R.raw.audio_234, "Pero la puta que te parió, llené la pantalla de mocos", Arrays.asList(
                        OBJ_TAG_LUACHA
                )),
                new Audio(R.raw.audio_235, "Hablá bien estúpido", Arrays.asList(
                        OBJ_TAG_UBER
                )),
                new Audio(R.raw.audio_236, "Vamos campeón mierdaaa!", Arrays.asList(
                        OBJ_TAG_FABRIO,
                        OBJ_TAG_RIVER
                )),
                new Audio(R.raw.audio_237, "Por fin hijo de re mil puta", Arrays.asList(
                        OBJ_TAG_FABRIO,
                        OBJ_TAG_HIJO_DE_PUTA
                )),
                new Audio(R.raw.audio_238, "Puta que te parió gilll", Arrays.asList(
                        OBJ_TAG_FABRIO,
                        OBJ_TAG_HIJO_DE_PUTA
                )),
                new Audio(R.raw.audio_239, "Aawww...", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_SONIDO
                )),
                new Audio(R.raw.audio_240, "Ay voy a estudiar y me distrae...bueno si, chupate una pija", Arrays.asList(
                        OBJ_TAG_UBER
                )),
                new Audio(R.raw.audio_241, "Ay que reco mameeeee!", Arrays.asList(
                        OBJ_TAG_NIGUIN,
                        OBJ_TAG_AY_QUE_RECO_MAME
                )),
                new Audio(R.raw.audio_242, "Estoy en la cama todavía, vo velo", Arrays.asList(
                        OBJ_TAG_FABRIO
                )),
                new Audio(R.raw.audio_243, "Dale guacho, me gusta la idea, ahí llevo unos guayma", Arrays.asList(
                        OBJ_TAG_NIGUIN
                )),
                new Audio(R.raw.audio_244, "AAGRRRRRRRRRHHHH!", Arrays.asList(
                        OBJ_TAG_FABRIO
                )),
                new Audio(R.raw.audio_245, "Ahora me voy a poner terriblemente borasho!", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_246, "Dale maneee, ponele onda!", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_247, "Te he eshado de menos, uber", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_248, "Ubeeeeeeeer!", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_249, "Y bueno, como les contaFFFFFFFFSSSSSHHHHHHH", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_VIENTO
                )),
                new Audio(R.raw.audio_250, "Y la puta madre", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_251, "Pero eso es otra ventaja", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_252, "Jodeeer", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_JODER
                )),
                new Audio(R.raw.audio_253, "Aayy, que te pasas de pelotudo", Arrays.asList(
                        OBJ_TAG_LUACHA,
                        OBJ_TAG_PELOTUDO
                )),
                new Audio(R.raw.audio_254, "Maneeeeee", Arrays.asList(
                        OBJ_TAG_LUACHA
                )),
                new Audio(R.raw.audio_255, "Cierren el orto", Arrays.asList(
                        OBJ_TAG_UBER
                )),
                new Audio(R.raw.audio_256, "No sé quién es més lindo, el gatito o el FGDFGDFGDFGD!", Arrays.asList(
                        OBJ_TAG_UBER
                )),
                new Audio(R.raw.audio_257, "Veo tumor.. tumorcillita", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_258, "Iiiiija iujuuu ujuu, UUUUUJUJU!", Arrays.asList(
                        OBJ_TAG_UBER
                )),
                new Audio(R.raw.audio_259, "Uuuma delicia", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_260, "Dame un poco de supa dee macacooo", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_261, "Anda a cagaaaaaaaar!", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_262, "Sos un hijo de FFFFFFFFSSSSSHHHHHHH!", Arrays.asList(
                        OBJ_TAG_GAJTAUN,
                        OBJ_TAG_VIENTO
                )),
                new Audio(R.raw.audio_263, "Y a quién le decis afeminado...ay sos un, sos un atrevidooo", Arrays.asList(
                        OBJ_TAG_UBER
                )),
                new Audio(R.raw.audio_264, "Que shale hoy, que shaleeeeee", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_265, "Sale rankazo?", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_266, "Vete a la mierdaaaaa!", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_267, "Vayanse a la mierda carajo!", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_268, "Pero bueno pero bueno pero bueno si tengo trepeta", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_269, "Estamos en esto por las drogas", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_270, "Andate a cagar, amigo de mentira", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_271, "Un pajero peluquero", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_272, "Es un juego de mierda..", Arrays.asList(
                        OBJ_TAG_UBER
                )),
                new Audio(R.raw.audio_273, "Que juego, que lo tiró, que juegazo loco, pero queee!", Arrays.asList(
                        OBJ_TAG_UBER
                )),
                new Audio(R.raw.audio_274, "Me chupa bien la chota", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_275, "Como te qudoooooo", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_276, "Andate a la mierda", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_277, "Soy enfermero...consulta...me muero!", Arrays.asList(
                        OBJ_TAG_UBER
                )),
                new Audio(R.raw.audio_278, "Hijo de puta", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_HIJO_DE_PUTA
                )),
                new Audio(R.raw.audio_279, "Ah que lindo, que hermoso...el michi también", Arrays.asList(
                        OBJ_TAG_UBER
                )),
                new Audio(R.raw.audio_280, "Chupen PIJA", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_281, "Como te quedooooo!", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_282, "Hijo de mil...PUTA", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_HIJO_DE_PUTA
                )),
                new Audio(R.raw.audio_283, "Posdata: PU TA ZO", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_284, "* Pac pac pac pac *... ajio ajio ajio", Arrays.asList(
                        OBJ_TAG_GAJTAUN,
                        OBJ_TAG_AJIO,
                        OBJ_TAG_SONIDO
                )),
                new Audio(R.raw.audio_285, "Bueno bueno, chupame la pija, CHUPAME LA PIJA", Arrays.asList(
                        OBJ_TAG_UBER
                )),
                new Audio(R.raw.audio_286, "Putin, puton, putin puton, putin puton putin puton", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_287, "Ajajá te pasas homobre, te pasas...jaja...very funny dude", Arrays.asList(
                        OBJ_TAG_UBER
                )),
                new Audio(R.raw.audio_288, "Me haces re maaaal..", Arrays.asList(
                        OBJ_TAG_GAJTAUN
                )),
                new Audio(R.raw.audio_289, "Contate otro mane", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_290, "Te vas al carajo marcel, cada vez peor estas eh..", Arrays.asList(
                        OBJ_TAG_LUACHA
                )),
                new Audio(R.raw.audio_291, "Clarito, si, ahi tenes que usar pitágoras porque", Arrays.asList(
                        OBJ_TAG_UBER
                )),
                new Audio(R.raw.audio_292, "Fabriiiiiiii", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_SALUDO
                )),
                new Audio(R.raw.audio_293, "Coman poiaaa, coman poiaaa ", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_COMAN_POIA
                )),
                new Audio(R.raw.audio_294, "Jeje, lo leí con voz de posho", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_295, "Guleeeee", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_SALUDO
                )),
                new Audio(R.raw.audio_296, "Agachate y conocelo jajaj...no es gracioso", Arrays.asList(
                        OBJ_TAG_UBER
                )),
                new Audio(R.raw.audio_297, "Manee, putazo", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_298, "Te digo cuantas luacha?, te digo?... CEEEE RO, entendiste? CEROO!", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_299, "CEEEE RO, entendiste? CEROO!", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_300, "No te lo queria decir por acá pero...PARTIME LA BOCA LOCO", Arrays.asList(
                        OBJ_TAG_UBER
                )),
                new Audio(R.raw.audio_301, "Madre de dios, parezco robocop", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_302, "Pishu, salvame, SALVAMEEEE!", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_303, "Dale pocho, sale algo", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_304, "Desde que no está pichu disponible, los patos dan pena!", Arrays.asList(
                        OBJ_TAG_GULI
                )),
                new Audio(R.raw.audio_305, "Igual voy y tomo algo, no necesito comer", Arrays.asList(
                        OBJ_TAG_GULI
                )),
                new Audio(R.raw.audio_306, "Voy, me prendo", Arrays.asList(
                        OBJ_TAG_GULI
                )),
                new Audio(R.raw.audio_307, "Igual voy y tomo algo", Arrays.asList(
                        OBJ_TAG_GULI
                )),
                new Audio(R.raw.audio_308, "Enhorabuena fabriiiii!", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_309, "Noooooo re lindos...yo les daba", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_310, "Si, viste que perra me consegui?.. jejeje", Arrays.asList(
                        OBJ_TAG_UBER
                )),
                new Audio(R.raw.audio_311, "Que hace pollo, que se esta tocando?... ah, wee huu sgdgdgd ", Arrays.asList(
                        OBJ_TAG_UBER
                )),
                new Audio(R.raw.audio_312, "Are you carpinchou? jeje", Arrays.asList(
                        OBJ_TAG_UBER
                )),
                new Audio(R.raw.audio_313, "Se está tocando el package", Arrays.asList(
                        OBJ_TAG_GAJTAUN
                )),
                new Audio(R.raw.audio_314, "No no, no lo iba a borrar, no soy cagón como vos...va...te quiero", Arrays.asList(
                        OBJ_TAG_UBER
                )),
                new Audio(R.raw.audio_315, "Ay que ternura, sos un tierno. Ay, te amo...ya era, ya era", Arrays.asList(
                        OBJ_TAG_UBER
                )),
                new Audio(R.raw.audio_316, "* Pac pac pac * Hola mi amoooor, estas viendo porno soloooo?", Arrays.asList(
                        OBJ_TAG_GAJTAUN
                )),
                new Audio(R.raw.audio_317, "Guliiiiiii", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_SALUDO
                )),
                new Audio(R.raw.audio_318, "Sos un asco, hijo de puta", Arrays.asList(
                        OBJ_TAG_FABRIO,
                        OBJ_TAG_HIJO_DE_PUTA
                )),
                new Audio(R.raw.audio_319, "Yo soy un hombre de pelo en pecho y mear en pared", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_320, "Se paga por ello, imbécil", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_321, "Mane, te podes ir bien a la mierda", Arrays.asList(
                        OBJ_TAG_LUACHA
                )),
                new Audio(R.raw.audio_322, "Luachita", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_323, "Veo tumor...tumor luachita", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_324, "Poio marica", Arrays.asList(
                        OBJ_TAG_HERRAIZ
                )),
                new Audio(R.raw.audio_325, "* Risa llorosa *", Arrays.asList(
                        OBJ_TAG_NIGUIN
                )),
                new Audio(R.raw.audio_326, "Furiiiiii, que lindas piernas", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_327, "Poiooooooo (4)", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_SALUDO
                )),
                new Audio(R.raw.audio_328, "Joder macho, oshtia puta", Arrays.asList(
                        OBJ_TAG_GAJTAUN,
                        OBJ_TAG_OSHTIAPUTA
                )),
                new Audio(R.raw.audio_329, "Seguiiiila comiendo, porteño puto, seguiiila comiendo \uD83C\uDFB5...", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_330, "Fabri te quierooooo", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_331, "Coman poiaaa, coman poiaaaaa", Arrays.asList(
                        OBJ_TAG_MARCE,
                        OBJ_TAG_COMAN_POIA
                )),
                new Audio(R.raw.audio_332, "Pero siempre gana darthtemoc", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_333, "Meee.. me presto para turnarme contigo", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_334, "Si pierde uruguay me corto los huevos y los pongo a secar al sol", Arrays.asList(
                        OBJ_TAG_UBER
                )),
                new Audio(R.raw.audio_335, "Ubercitooo, mi amor", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_336, "Ay que leeeendo mi gastooon", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_337, "La puta madre uruguaaaaaay!", Arrays.asList(
                        OBJ_TAG_MARCE
                )),
                new Audio(R.raw.audio_338, "Vamo a ver si mi ataque relámpago verga funciona", Arrays.asList(
                        OBJ_TAG_MANE
                )),
                new Audio(R.raw.audio_339, "Ay luacha la puta madre..", Arrays.asList(
                        OBJ_TAG_MANE
                )),
                new Audio(R.raw.audio_340, "Bueno, a ver", Arrays.asList(
                        OBJ_TAG_MANE
                )),
                new Audio(R.raw.audio_341, "Si, les destruí el castillo. Tomá la puta que te parió jajaja", Arrays.asList(
                        OBJ_TAG_MANE
                )),
                new Audio(R.raw.audio_342, "Tomá la puta que te parió", Arrays.asList(
                        OBJ_TAG_MANE
                )),
                new Audio(R.raw.audio_343, "Che les destrullo el castillo y me cago de risa", Arrays.asList(
                        OBJ_TAG_MANE
                )),
                new Audio(R.raw.audio_344, "Si señor, eso si es verdad", Arrays.asList(
                        OBJ_TAG_MANE
                )),
                new Audio(R.raw.audio_345, "Es un verga boludo..", Arrays.asList(
                        OBJ_TAG_MANE
                )),
                new Audio(R.raw.audio_346, "Jajá", Arrays.asList(
                        OBJ_TAG_MANE
                )),
                new Audio(R.raw.audio_347, "Dale la concha de tu hermana, matalos", Arrays.asList(
                        OBJ_TAG_MANE
                )),
                new Audio(R.raw.audio_348, "Yo quiero poronga", Arrays.asList(
                        OBJ_TAG_MANE
                )),
                new Audio(R.raw.audio_349, "Matad", Arrays.asList(
                        OBJ_TAG_MANE
                )),
                new Audio(R.raw.audio_350, "Mirá mirá", Arrays.asList(
                        OBJ_TAG_MANE
                )),
                new Audio(R.raw.audio_351, "No lo dije yo pero es verdad", Arrays.asList(
                        OBJ_TAG_MANE
                )),
                new Audio(R.raw.audio_352, "No no no, no mires nada", Arrays.asList(
                        OBJ_TAG_MANE
                )),
                new Audio(R.raw.audio_353, "Dale vayan muchachos", Arrays.asList(
                        OBJ_TAG_MANE
                )),
                new Audio(R.raw.audio_354, "Pone nervioso", Arrays.asList(
                        OBJ_TAG_MANE
                )),
                new Audio(R.raw.audio_355, "Probablemente no", Arrays.asList(
                        OBJ_TAG_MANE
                )),
                new Audio(R.raw.audio_356, "Si", Arrays.asList(
                        OBJ_TAG_MANE
                )),
                new Audio(R.raw.audio_357, "Si si si si", Arrays.asList(
                        OBJ_TAG_MANE
                )),
                new Audio(R.raw.audio_358, "Tomá la puta que te paró", Arrays.asList(
                        OBJ_TAG_MANE
                )),
                new Audio(R.raw.audio_359, "Seguro?", Arrays.asList(
                        OBJ_TAG_MANE
                ))
        );
    }
}
