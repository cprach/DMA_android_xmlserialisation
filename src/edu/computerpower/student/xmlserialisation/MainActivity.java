package edu.computerpower.student.xmlserialisation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import javax.xml.*;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	List<Player> playerList = new ArrayList<Player>();
	private static final String ns = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	

	public void addPlayer(View v) {

		TextView txtPlayerName = (TextView)findViewById(R.id.txtPlayerName);
		TextView txtPlayerScore = (TextView)findViewById(R.id.txtPlayerScore);

		if (txtPlayerName.getText().toString() != "" && txtPlayerScore.getText().toString() != "") {
			Log.d("add players >>>", txtPlayerName.getText().toString() + " " + txtPlayerScore.getText().toString());

			Player player = new Player();
			player.setName(txtPlayerName.getText().toString());
			player.setScore(Integer.parseInt(txtPlayerScore.getText().toString()));
			playerList.add(player);

			Log.d("new player", Integer.toString(player.getScore()));
		}

	}

	public void storeData(View v) {

//		JAXBContext jc = JAXBContext.newInstance(ServerManager.class);
//
//        File xml = new File("playerdataxml2.xml");
//        Unmarshaller unmarshaller = jc.createUnmarshaller();
//        ServerManager serverManager = (ServerManager) unmarshaller.unmarshal(xml);
//        
//        System.out.println("xxx" + serverManager.getServers().size());
		
		
		
		String filename = "playerdatafile";
		String string = "Hello world!";
		FileOutputStream outputStream;

		try {
			outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
			outputStream.write(string.getBytes());
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void retrieveData(View v) {

		String filename = "playerdatafile";

		FileInputStream inputStream;

		try {
			inputStream = openFileInput(filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
//	public List parse(InputStream in) throws XmlPullParserException, IOException {
//        try {
//            XmlPullParser parser = Xml.newPullParser();
//            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
//            parser.setInput(in, null);
//            parser.nextTag();
//            return readFeed(parser);
//        } finally {
//            in.close();
//        }
//    }
//	
//	private List readFeed(XmlPullParser parser) throws XmlPullParserException, IOException {
//	    List entries = new ArrayList();
//
//	    parser.require(XmlPullParser.START_TAG, ns, "feed");
//	    while (parser.next() != XmlPullParser.END_TAG) {
//	        if (parser.getEventType() != XmlPullParser.START_TAG) {
//	            continue;
//	        }
//	        String name = parser.getName();
//	        // Starts by looking for the entry tag
//	        if (name.equals("entry")) {
//	            entries.add(readEntry(parser));
//	        } else {
//	            skip(parser);
//	        }
//	    }  
//	    return entries;
//	}
	
}
