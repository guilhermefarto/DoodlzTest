package com.deitel.doodlz.test;

import android.test.ActivityInstrumentationTestCase2;
import android.view.KeyEvent;
import com.deitel.doodlz.Doodlz;
import com.deitel.doodlz.R;
import com.deitel.doodlz.test.util.TestCaseUtil;
import com.robotium.solo.Solo;

public class DM7CaseTest extends ActivityInstrumentationTestCase2 {

	private Solo solo;

	@SuppressWarnings("unchecked")
	public DM7CaseTest() {
		super(Doodlz.class);
	}

	@Override
	public void setUp() throws Exception {
		solo = new Solo(getInstrumentation(), getActivity());
	}

	public void testCesOne() throws Exception {
		String cesOne = "Main_screen, Create_drawing, Press_Menu, Choose_color, Define_green, Press_Set_Color, Back_to_main_screen";

		TestCaseUtil.executeTestCase(this, DM7CaseTest.class, cesOne);
	}

	public void testCesTwo() throws Exception {
		String cesTwo = "Main_screen, Create_drawing, Press_Menu, Define_Line_Width, Press_Set_Line_Width, Back_to_main_screen";

		TestCaseUtil.executeTestCase(this, DM7CaseTest.class, cesTwo);
	}

	public void testCesThree() throws Exception {
		String cesThree = "Main_screen, Create_drawing, Press_Menu, Erase, Back_to_main_screen";

		TestCaseUtil.executeTestCase(this, DM7CaseTest.class, cesThree);
	}

	public void testCesFour() throws Exception {
		String cesFour = "Main_screen, Create_drawing, Press_Menu, Clear, Back_to_main_screen";

		TestCaseUtil.executeTestCase(this, DM7CaseTest.class, cesFour);
	}

	public void testCesFive() throws Exception {
		String cesFive = "Main_screen, Create_drawing, Press_Menu, Save_image, Back_to_main_screen";

		TestCaseUtil.executeTestCase(this, DM7CaseTest.class, cesFive);
	}

	public void testCesSix() throws Exception {
		String cesSix = "Main_screen, Create_drawing, Press_Menu, Choose_color, Define_blue, Press_Set_Color, Back_to_main_screen";

		TestCaseUtil.executeTestCase(this, DM7CaseTest.class, cesSix);
	}

	public void testCesSeven() throws Exception {
		String cesSeven = "Main_screen, Create_drawing, Press_Menu, Choose_color, Define_red, Press_Set_Color, Back_to_main_screen";

		TestCaseUtil.executeTestCase(this, DM7CaseTest.class, cesSeven);
	}

	public void testCesEight() throws Exception {
		String cesEight = "Main_screen, Create_drawing, Press_Menu, Choose_color, Define_alpha, Press_Set_Color, Back_to_main_screen";

		TestCaseUtil.executeTestCase(this, DM7CaseTest.class, cesEight);
	}

	public void Main_screen() throws Exception {
	}

	public void Create_drawing() throws Exception {
		solo.drag(60, 220, 80, 300, 10);
	}

	public void Press_Menu() throws Exception {
		new Thread(new Runnable() {
			public void run() {
				getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_MENU);
			}
		}).start();
	}

	public void Choose_color() throws Exception {
		solo.clickOnMenuItem(solo.getString(R.string.menuitem_color));
	}

	public void Press_Set_Color() throws Exception {
		solo.clickOnButton(solo.getString(R.string.button_set_color));
	}

	public void Back_to_main_screen() throws Exception {
	}

	public void Define_Line_Width() throws Exception {
		solo.clickOnMenuItem(solo.getString(R.string.menuitem_line_width));

		solo.setProgressBar(0, 25);
	}

	public void Press_Set_Line_Width() throws Exception {
		solo.clickOnButton(solo.getString(R.string.button_set_line_width));
	}

	public void Erase() throws Exception {
		solo.clickOnMenuItem(solo.getString(R.string.menuitem_erase));
	}

	public void Clear() throws Exception {
		solo.clickOnMenuItem(solo.getString(R.string.menuitem_clear));
	}

	public void Save_image() throws Exception {
		solo.clickOnMenuItem(solo.getString(R.string.menuitem_save_image));

		boolean actualTest = solo.waitForText(solo.getString(R.string.message_saved));

		assertEquals("Message Saved not found", true, actualTest);
	}

	public void Define_red() throws Exception {
		solo.setProgressBar(0, 125);
	}

	public void Define_green() throws Exception {
		solo.setProgressBar(1, 62);
	}

	public void Define_blue() throws Exception {
		solo.setProgressBar(2, 187);
	}

	public void Define_alpha() throws Exception {
		solo.setProgressBar(3, 0);
	}

	@Override
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}

}
