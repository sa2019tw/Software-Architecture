--------關於安裝---------
JDK: https://www.oracle.com/technetwork/java/javase/downloads/index.html(好像可以不用安裝)
Android Studio: https://developer.android.com/studio/index.html
進到android studio 還有下載gradle (有些電腦會自動安裝)，我記得他有跳出dialog，我點連結他就幫我載好了(點擊下方Build的tab會有提示的連結)
下載軟體的參考網址:https://ithelp.ithome.com.tw/articles/10200176?sc=iThelpR


--------關於程式---------
HW1我沒有把程式分房間，所以code都在下面的路徑
107598069\sa_hw\app\src\main\java\com\example\sa_hw

Code
關於SQLite: CreateDB、FeedReaderContract、FeedReaderDbHelper
程式主頁面: MainActivity
新增一筆課程資料的頁面: InfoData
修改一筆課程資料的頁面: updateData
為了要顯示在主頁面的listView上的方法: MyCursorAdapter

有關User使用的View的XML路徑在:
107598069\sa_hw\app\src\main\res\layout
主頁面: activity_main.xml
顯示新增資料的頁面: activity_info_data.xml
顯示修改資料的頁面: activity_update_data.xml
定義listView的樣子: activity_page2.xml

--------關於run---------
我試了三個方式跑起我的程式:
1.安裝虛擬機 (我試了很多電腦，有些要進BIOS設定VT-x enable，且不一定成功)
  step1.
  Tool->AVD Manager->Create Virtual Device...->Category(phone)->(我是選)Nexus 5X->Next->(我是選)Pie 要Download->Next->Finish

  step2.
  安裝好就可以選Run->Run 'App'->選剛剛被安裝好的虛擬器->OK
通常一開始的虛擬機要建置約2mins

2.傳輸線配手機
  step1.手機要先調成開發人員模式
  step2.USB偵錯要開啟
  step3.手機要調成傳輸檔案(非僅充電)
  step4.Run->Run 'App'->選自己的手機->OK

3.匯出成apk
  step1.
  Build->Build Bundle(s)/APK(s)->Build APK(s)

  step2.
  建好後右下角會有個提示框，顯示apk在哪個路徑下，選'locate'

  step3.
  資料夾內會有個匯出的apk檔
  
  step4.
  我把他丟到雲端，再從手機連雲端下載下來，就可以執行了

--------關於操作方式---------
新增課程: 要輸入一個課程名稱不能會空白的課(新增後會跳回主頁面，按列出所有課程會將剛剛新增的課程顯示)
刪除課程: 先點選ListView再點選刪除課程，被選取的課程就會被刪除
修改課程: 先點選ListView再點選修改課程，會跳出要被修改的課程內容(新增後會跳回主頁面，按列出所有課程會將剛剛修改的課程顯示)
列出所有課程: 會將課程顯示