sc stop "OracleServiceXE"
sc stop "OracleOraDB21Home1TNSListener"
sc stop "OracleOraDB21Home1MTSRecoveryService"
sc stop "OracleJobSchedulerXE"
sc config "OracleServiceXE" start= demand
sc config "OracleOraDB21Home1TNSListener" start= demand
sc config "OracleOraDB21Home1MTSRecoveryService" start= demand
sc config "OracleJobSchedulerXE" start= demand

SET /P P="±â´Ù·Á":