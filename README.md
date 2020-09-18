# officeshift-timestamper
Commandline application for logging machine logon/logoff time into file system. 
To help people know their working time without opening Windows Event Viewer.  

## How to build and run
1. `mvn clean package`
2. `java -cp target/officeshift-timestamper-0.0.1-SNAPSHOT.jar io.github.batenzar.Main /home/youhome/output/log false`  
Note: true=logon, false=logoff


## How to install
### For Startup
1. Win+R
2. Type 'shell:startup'
3. Paste 'exec.bat' shortcut 
or 
1. Win+R
2. Type 'gpedit.msc'
3. Go to 'User Configuration' -> 'Windows Settings' -> 'Script (Logon/Logoff)'
4. Double click on 'Startup'
5. Click 'Show files ...'
6. Paste exec_2_login.bat into the folder
7. In Startup properties, click 'Add...' and select the 'exec_2_login.bat'


### For Shutdown
1. Win+R
2. Type 'gpedit.msc'
3. Go to 'User Configuration' -> 'Windows Settings' -> 'Script (Logon/Logoff)'
4. Double click on 'Shutdown'
5. Click 'Show files ...'
6. Paste exec_2_logoff.bat into the folder
7. In Shutdown properties, click 'Add...' and select the 'exec_2_logoff.bat'

## Changelogs
V2.
- Choose to log logon/logoff times
- Add log file to keep all working date

V1.
- Always log to "D:\log_com_usage\only"
- Create new folder which contains log file inside
- Log current time to file
- Check date inside the file before replacing file content
