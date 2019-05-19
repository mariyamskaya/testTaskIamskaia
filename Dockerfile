# Use an official Maven runtime as a parent image
FROM maven:3.6.1-jdk-8

# Set the working directory to /app
WORKDIR /app

# Install any needed packages
RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add
RUN echo "deb http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list
RUN apt-get update
RUN apt-get install xvfb -y
RUN apt-get install google-chrome-stable curl -y
RUN Xvfb :1 -screen 0 1920x1024x24 -fbdir /var/tmp&
RUN export DISPLAY=localhost:1.0
# Install chromedriver
RUN rm /usr/local/bin/chromedriver -f
RUN wget -N http://chromedriver.storage.googleapis.com/`curl -sS chromedriver.storage.googleapis.com/LATEST_RELEASE`/chromedriver_linux64.zip -P ~/
RUN unzip ~/chromedriver_linux64.zip -d ~/
RUN rm ~/chromedriver_linux64.zip
RUN mv -f ~/chromedriver /usr/local/bin/chromedriver
RUN chown root:root /usr/local/bin/chromedriver
RUN chmod 0755 /usr/local/bin/chromedriver
