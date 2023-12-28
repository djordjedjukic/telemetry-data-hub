
# Interview task

I decided to use RavenDB, because I am very familiar with it, and it fits perfectly for this case. Also, I want to use the opportunity to pitch this great piece of software. :)

I would do this test a little bit differently in the .net world, but I tried to follow the project structure which is "by the book" in the Java world.
So I have packages: controller, service, model, infrastructure. What I don't have is the repository package. Because I am new in the Java world,
I wasn't familiar with the JpaRepository concept and how it would fit with Ravendb, so I decided not to use it for this purpose. In any case that shouldn't be a problem, because ravendb sdk already implements a Rep/UoW pattern.

What I think can be improved is error handling and logging. I have a really elegant way how I am doing that in c#, using middleware pipelines, where I am logging every request/response, duration of request, and a lot of other things.
The same thing is with error handling. I think those two things are very important, and I would probably ask some experienced java devs, what is best practice.

RavenDB indexes are very powerful, but I skipped it for this purpose, filtering is still very fast.

I would add paging in filtering because now the result can contain a lot of data.



## Tech Stack

**Server:** Java, RavenDB


## Run Locally

Clone the project

```bash
  git clone https://github.com/djordjedjukic/telemetry-data-hub.git
```

Go to the project directory

```bash
  cd my-project
```

Start the server

```bash
  mvn spring-boot:run
```
