install: # чистка и сборка
		 ./gradlew clean install
run-dist: # запуск приложения
		  ./build/install/app/bin/app
check-updates: 
			   ./gradlew dependencyUpdates
lint: 
	  ./gradlew checkstyleMain