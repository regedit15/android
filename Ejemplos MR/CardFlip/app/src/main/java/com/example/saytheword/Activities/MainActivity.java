package com.example.saytheword.Activities;

import android.os.Bundle;
import android.view.View;

import com.example.saytheword.Fragments.CardBack;
import com.example.saytheword.Fragments.CardFront;
import com.example.saytheword.R;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	private boolean showingBack = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction().add(R.id.contenedor, new CardFront()).commit();
		}
	}

	public void aaa(View view) {
		flipCard();
	}

	private void flipCard() {
		if (showingBack) {
			getSupportFragmentManager().popBackStack();
		} else {


			// Flip to the back.

			// Create and commit a new fragment transaction that adds the fragment for
			// the back of the card, uses custom animations, and is part of the fragment
			// manager's back stack.

			getSupportFragmentManager().beginTransaction()

					// Replace the default fragment animations with animator resources
					// representing rotations when switching to the back of the card, as
					// well as animator resources representing rotations when flipping
					// back to the front (e.g. when the system Back button is pressed).
					.setCustomAnimations(R.animator.card_flip_right_in, R.animator.card_flip_right_out, R.animator.card_flip_left_in, R.animator.card_flip_left_out)

					// Replace any fragments currently in the container view with a
					// fragment representing the next page (indicated by the
					// just-incremented currentPage variable).
					.replace(R.id.contenedor, new CardBack())

					// Add this transaction to the back stack, allowing users to press
					// Back to get to the front of the card.
					.addToBackStack(null)

					// Commit the transaction.
					.commit();
		}

		showingBack = !showingBack;
	}
}
