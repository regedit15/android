package com.example.seccion09_fragment_tarea.services;

import android.graphics.Color;

import java.util.Random;

public class UtilService {

	private String[] colores = {"#FF8A80", "#FF80AB", "#EA80FC", "#B388FF", "#8C9EFF", "#82B1FF", "#80D8FF", "#84FFFF", "#A7FFEB", "#B9F6CA", "#CCFF90", "#F4FF81", "#FFFF8D", "#FFD180", "#FF9E80",};

	public int getColorRandom() {
		return Color.parseColor(colores[new Random().nextInt(14)]);
	}
}
