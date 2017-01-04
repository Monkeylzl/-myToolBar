package com.example.mytoolbar;

import android.app.Activity;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	private Toolbar toolbar;
	private ImageView more;
	private PopupMenu popupMenu;
	private Menu menu;
	 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		toolbar = (Toolbar) findViewById(R.id.toolbar);		
		
		//ʹ��PopupWindow��ʵ��Menu�������Զ����toolbar���������޷�����Menu����
//		popupMenu = new PopupMenu(this, findViewById(R.id.more));
//		menu = popupMenu.getMenu();
        //ͨ��������Ӳ˵���
//		menu.add(Menu.NONE, Menu.FIRST + 0, 0, "����");
//		menu.add(Menu.NONE, Menu.FIRST + 1, 1, "ճ��");
//		//ͨ��XML�ļ���Ӳ˵���
//		MenuInflater menuInflater = getMenuInflater();
//		menuInflater.inflate(R.menu.popupmenu, menu);	
		
//		popupMenu.setOnMenuItemClickListener(new OnMenuItemClickListener() {
//		   public boolean onMenuItemClick(MenuItem item) {
//				switch (item.getItemId()) {
//				 case R.id.save:
//				 Toast.makeText(MainActivity.this, "����",
//				 Toast.LENGTH_LONG).show();
//				 break;
//				case Menu.FIRST + 0:
//					Toast.makeText(MainActivity.this, "����", Toast.LENGTH_LONG)
//							.show();
//					break;
//				case Menu.FIRST + 1:
//					Toast.makeText(MainActivity.this, "ճ��", Toast.LENGTH_LONG)
//							.show();
//					break;
//				default:
//					break;
//				}
//				return false;
//			}
//		});


		setSupportActionBar(toolbar);
		//title��XML�ļ�������Ϊtoolbar:title="Title"��ǰ����
		//��RelativeLayout�����xmlns:toolbar="http://schemas.android.com/apk/res-auto"
		//�õĲ���android:�����ռ䣬�����Զ��������ռ�
//		getSupportActionBar().setTitle("Title");
		getSupportActionBar().setSubtitle("subTitle");
		getSupportActionBar().setLogo(R.drawable.ic_launcher);
		toolbar.setNavigationIcon(R.drawable.ic_launcher2);

	}
    //��XML��������Onclick
	public void popupmenu(View v) {
		popupMenu.show();
	}
//	ʹ��toolbar��ʵ��Menu���Զ����toolbar�������п��Ը���Menu����
	@Override
	public boolean onCreateOptionsMenu(Menu menu) { 
	       getMenuInflater().inflate(R.menu.main, menu);  
			menu=toolbar.getMenu();
	        //ͨ��������Ӳ˵���
			menu.add(Menu.NONE, Menu.FIRST + 0, 0, "����");
			menu.add(Menu.NONE, Menu.FIRST + 1, 1, "ճ��");
			//ͨ��XML�ļ���Ӳ˵���
			MenuInflater menuInflater = getMenuInflater();
			menuInflater.inflate(R.menu.popupmenu, menu);
			toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
		            @Override
		            public boolean onMenuItemClick(MenuItem item) {
		                switch (item.getItemId()) {
		                    case Menu.FIRST + 0:
		                        Toast.makeText(MainActivity.this, "����", Toast.LENGTH_SHORT).show();
		                        break;
		                    case Menu.FIRST + 1:
		                        Toast.makeText(MainActivity.this, "ճ��", Toast.LENGTH_SHORT).show();
		                        break;
		                    case R.id.save:
		                        Toast.makeText(MainActivity.this, "����", Toast.LENGTH_SHORT).show();
		                        break;
		                    case R.id.delete:
		                        Toast.makeText(MainActivity.this, "ɾ��", Toast.LENGTH_SHORT).show();
		                        break;
		                }
		                return true;//return false ������
		            }
		        });
	       return true;
	       
	}
}
