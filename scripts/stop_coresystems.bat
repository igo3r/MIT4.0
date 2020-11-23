@ECHO OFF

echo Shutting down Core Systems

SET time_to_sleep=5

FOR /F "tokens=1" %%p in ('"jps -v | find "orchestrator""') DO taskkill /pid %%p > NUL 2>&1
FOR /F "tokens=1" %%p in ('"jps -v | find "authorization""') DO taskkill /pid %%p > NUL 2>&1
timeout /t %time_to_sleep% /nobreak > NUL
FOR /F "tokens=1" %%p in ('"jps -v | find "serviceregistry""') DO taskkill /pid %%p > NUL 2>&1

timeout /t 2 /nobreak > NUL
SET STILL_THERE=""

FOR /F "tokens=1" %%p in ('"jps -v | find "serviceregistry""') DO set STILL_THERE=%%p

IF "%STILL_THERE%"=="""" (
  echo Core systems killed
) ELSE (
  FOR /F "tokens=1" %%p in ('"jps -v | find "orchestrator""') DO taskkill /F /pid %%p
  FOR /F "tokens=1" %%p in ('"jps -v | find "authorization""') DO taskkill /F /pid %%p
  FOR /F "tokens=1" %%p in ('"jps -v | find "serviceregistry""') DO taskkill /F /pid %%p
  echo Core systems forcefully killed
)
