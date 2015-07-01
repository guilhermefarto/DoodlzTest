package com.deitel.doodlz.test;

import android.test.ActivityInstrumentationTestCase2;
import com.deitel.doodlz.Doodlz;
import com.deitel.doodlz.R;
import com.robotium.solo.Solo;

public class DoodlzCaseTest extends ActivityInstrumentationTestCase2 {

	private Solo solo;

	private boolean actualTest = false;

	@SuppressWarnings("unchecked")
	public DoodlzCaseTest() {
		super(Doodlz.class);
	}

	@Override
	public void setUp() throws Exception {
		solo = new Solo(getInstrumentation(), getActivity());
	}

	public void testApp() {
		solo.clickOnMenuItem(solo.getString(R.string.menuitem_color));

		solo.sleep(1000);

		solo.setProgressBar(0, 125);
		solo.setProgressBar(1, 62);
		solo.setProgressBar(2, 187);
		solo.setProgressBar(3, 0);

		solo.clickOnButton(solo.getString(R.string.button_set_color));

		solo.sleep(1000);

		solo.clickOnMenuItem(solo.getString(R.string.menuitem_line_width));

		solo.sleep(1000);

		solo.setProgressBar(0, 25);

		solo.clickOnButton(solo.getString(R.string.button_set_line_width));

		solo.sleep(1000);

		solo.drag(60, 220, 80, 300, 10);

		solo.sleep(1000);

		solo.clickOnMenuItem(solo.getString(R.string.menuitem_clear));

		solo.sleep(1000);

		solo.drag(60, 220, 80, 300, 10);

		solo.sleep(1000);

		solo.clickOnMenuItem(solo.getString(R.string.menuitem_erase));

		solo.sleep(1000);

		solo.drag(50, 200, 260, 140, 10);

		solo.clickOnMenuItem(solo.getString(R.string.menuitem_save_image));

		solo.sleep(1000);

		actualTest = solo.waitForText(solo.getString(R.string.message_saved));

		assertEquals("Message Saved not found", true, actualTest);
	}

	@Override
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}

}
