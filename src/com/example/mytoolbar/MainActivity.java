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
		
		//使用PopupWindow来实现Menu，但是自定义的toolbar在主题中无法更改Menu主题
//		popupMenu = new PopupMenu(this, findViewById(R.id.more));
//		menu = popupMenu.getMenu();
        //通过代码添加菜单项
//		menu.add(Menu.NONE, Menu.FIRST + 0, 0, "复制");
//		menu.add(Menu.NONE, Menu.FIRST + 1, 1, "粘贴");
//		//通过XML文件添加菜单项
//		MenuInflater menuInflater = getMenuInflater();
//		menuInflater.inflate(R.menu.popupmenu, menu);	
		
//		popupMenu.setOnMenuItemClickListener(new OnMenuItemClickListener() {
//		   public boolean onMenuItemClick(MenuItem item) {
//				switch (item.getItemId()) {
//				 case R.id.save:
//				 Toast.makeText(MainActivity.this, "保存",
//				 Toast.LENGTH_LONG).show();
//				 break;
//				case Menu.FIRST + 0:
//					Toast.makeText(MainActivity.this, "复制", Toast.LENGTH_LONG)
//							.show();
//					break;
//				case Menu.FIRST + 1:
//					Toast.makeText(MainActivity.this, "粘贴", Toast.LENGTH_LONG)
//							.show();
//					break;
//				default:
//					break;
//				}
//				return false;
//			}
//		});


		setSupportActionBar(toolbar);
		//title在XML文件中设置为toolbar:title="Title"，前提是
		//在RelativeLayout中添加xmlns:toolbar="http://schemas.android.com/apk/res-auto"
		//用的不是android:命名空间，而是自定义命名空间
//		getSupportActionBar().setTitle("Title");
		getSupportActionBar().setSubtitle("subTitle");
		getSupportActionBar().setLogo(R.drawable.ic_launcher);
		toolbar.setNavigationIcon(R.drawable.ic_launcher2);

	}
    //在XML中设置了Onclick
	public void popupmenu(View v) {
		popupMenu.show();
	}
//	使用toolbar来实现Menu，自定义的toolbar在主题中可以更改Menu主题
	@Override
	public boolean onCreateOptionsMenu(Menu menu) { 
	       getMenuInflater().inflate(R.menu.main, menu);  
			menu=toolbar.getMenu();
	        //通过代码添加菜单项
			menu.add(Menu.NONE, Menu.FIRST + 0, 0, "复制");
			menu.add(Menu.NONE, Menu.FIRST + 1, 1, "粘贴");
			//通过XML文件添加菜单项
			MenuInflater menuInflater = getMenuInflater();
			menuInflater.inflate(R.menu.popupmenu, menu);
			toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
		            @Override
		            public boolean onMenuItemClick(MenuItem item) {
		                switch (item.getItemId()) {
		                    case Menu.FIRST + 0:
		                        Toast.makeText(MainActivity.this, "复制", Toast.LENGTH_SHORT).show();
		                        break;
		                    case Menu.FIRST + 1:
		                        Toast.makeText(MainActivity.this, "粘贴", Toast.LENGTH_SHORT).show();
		                        break;
		                    case R.id.save:
		                        Toast.makeText(MainActivity.this, "保存", Toast.LENGTH_SHORT).show();
		                        break;
		                    case R.id.delete:
		                        Toast.makeText(MainActivity.this, "删除", Toast.LENGTH_SHORT).show();
		                        break;
		                }
		                return true;//return false 的区别
		            }
		        });
	       return true;
	       
	}
}
