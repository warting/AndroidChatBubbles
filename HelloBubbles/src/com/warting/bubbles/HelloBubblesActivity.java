package com.warting.bubbles;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import de.svenjacobs.loremipsum.LoremIpsum;

public class HelloBubblesActivity extends Activity {
	private com.warting.bubbles.DiscussArrayAdapter adapter;
	private ListView lv;
	private LoremIpsum ipsum;
	private EditText editText1;
	private static Random random;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_discuss);
		random = new Random();
		ipsum = new LoremIpsum();

		lv = (ListView) findViewById(R.id.listView1);

		adapter = new DiscussArrayAdapter(getApplicationContext(), R.layout.listitem_discuss);

		lv.setAdapter(adapter);

		editText1 = (EditText) findViewById(R.id.editText1);
		editText1.setOnKeyListener(new OnKeyListener() {
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				// If the event is a key-down event on the "enter" button
				if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
					// Perform action on key press
					adapter.add(new OneComment(false, editText1.getText().toString()));
					editText1.setText("");
					return true;
				}
				return false;
			}
		});

		addItems();
	}

	private void addItems() {
		adapter.add(new OneComment(true, "Hello bubbles!"));

		for (int i = 0; i < 4; i++) {
			boolean left = getRandomInteger(0, 1) == 0 ? true : false;
			int word = getRandomInteger(1, 10);
			int start = getRandomInteger(1, 40);
			String words = ipsum.getWords(word, start);

			adapter.add(new OneComment(left, words));
		}
	}

	private static int getRandomInteger(int aStart, int aEnd) {
		if (aStart > aEnd) {
			throw new IllegalArgumentException("Start cannot exceed End.");
		}
		long range = (long) aEnd - (long) aStart + 1;
		long fraction = (long) (range * random.nextDouble());
		int randomNumber = (int) (fraction + aStart);
		return randomNumber;
	}

}