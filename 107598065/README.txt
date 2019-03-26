//--下載程式--//
1.進入Qt官網，https://www.qt.io/
2.點選右上角按鈕(Download. Try. Buy)進入Get Qt頁面
3.Qt的程式有兩種版本，Commercial和Open Source，我們選擇用Open Source版本的，所以將頁面往下滾動，可以看到Open Source欄位最底下有個按鈕(Go open source)，點選那個按鈕(Go open source)
4.接下來會進入到Install Qt頁面，這裡可以選擇線上安裝或是下載離線安裝包，我選擇的是下載離線安裝包，所以將頁面往下滾動一些，可以看到有一行綠字(offline packages you can get them here.)，點選那行綠字
5.之後會進入到Offline Installers頁面，在這個頁面依據作業環境的不同，選擇不同的離線安裝檔，我個人是使用Windows Host


//--安裝程式--//
(在此是使用Windows Host安裝檔進行安裝，其他作業系統的安裝檔可能會不同)
1.下載好離線安裝檔後，點及安裝檔進行安裝
2.安裝步驟和其他程式差不多，只有一個地方要注意，就是在Select Components的頁面，
在Qt->Qt5.12.1下面必須要勾選
(1)MinGW 7.3.0 64-bit
(2)Qt Charts
(3)Qt Data Visualization
(4)Qt Purchasing
(5)Qt Virtual Keyboard
(6)Qt WebEngine
(7)Qt Network Authorization
(8)Qt WebGL Streaming Plugin
在Qt->Tools下面必須勾選
(1)Qt Creator 4.8.1 CDB Debugger Support
(2)MinGW 7.3.0 64-bit


//--執行程式--//
1.開啟Qt Creator
2.選取File->Open File or Project...
3.找到hw1專案的地方，選取副檔名為.pro檔的，並開啟
4.先(Ctrl+B)建置專案，再(Ctrl+R)執行專案
