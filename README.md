# Grange application
___
This application allows to manage a grange.
The *home office* oversees the work of the entire grange. The other buildings provide information to the home office about their specializations daily. The home-office application generates weekly and monthly reports on the average productivity of employees and the amount of products produced. 


## How to run everything
___
1. Run the *clean* Gradle task in the home-office directory.
2. Run the *bootJar* Gradle task in the home-office directory.
3. Fill in usernames and passwords in the 'docker-compose.yml' file.
4. Run the `'docker-compose up -d'` command in the IntelliJ terminal.

### What to do if this does not work
___
1. Delete the docker image.
2. Delete the docker container.
3. Repeat all steps from the *'How to run home-office'* section, making sure the passwords and usernames you entered are correct.

### What to do if the above instructions did not help
___
1. Delete the docker image.
2. Delete the docker container.
3. Run the `'docker system prune'` command in the IntelliJ terminal.
4. Repeat all steps from the *'How to run home-office'* section, making sure the passwords and usernames you entered are correct.
