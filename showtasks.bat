call runcrud.bat
if "%ERRORLEVEL%" == "0" goto startfirefox
goto fail

:startfirefox
call start firefox http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end

:fail
echo.
echo There were errors

:end
echo.
echo Everything done