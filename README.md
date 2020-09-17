# officeshift-timestamper

## Changelogs
V2.
- Choose to log logon/logoff times
- Add log file to keep all working date

V1.
- Always log to "D:\Play_projects\log_com_usage\only"
- Create new folder which contains log file inside
- Log current time to file
- Check date inside the file before replacing file content

## How to install
### For Startup
1. Ctrl+R
2. Type 'shell:startup'
3. Paste 'exec.bat' shortcut 
or 
1. Ctrl+R
2. Type 'gpedit.msc'
3. Go to 'Computer Configuration' -> 'Windows Settings' -> 'Script (Startup/Shutdown)'
4. Double click on 'Startup'
5. Click 'Show files ...'
6. Paste exec_2_login.bat into the folder
7. In Startup properties, click 'Add...' and select the 'exec_2_login.bat'


### For Shutdown
1. Ctrl+R
2. Type 'gpedit.msc'
3. Go to 'Computer Configuration' -> 'Windows Settings' -> 'Script (Startup/Shutdown)'
4. Double click on 'Shutdown'
5. Click 'Show files ...'
6. Paste exec_2_logoff.bat into the folder
7. In Shutdown properties, click 'Add...' and select the 'exec_2_logoff.bat'
