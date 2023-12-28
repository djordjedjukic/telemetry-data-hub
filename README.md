
# Interview task

I decided to use RavenDB, because I am very familiar with it, and it fits perfectly for this case. Also, I want to use the opportunity to pitch this great piece of software. :)

I would do this test a little bit differently in the .net world, but I tried to follow the project structure which is "by the book" in the Java world.
So I have packages: controller, service, model, infrastructure. What I don't have is the repository package. Because I am new in the Java world,
I wasn't familiar with the JpaRepository concept and how it would fit with Ravendb, so I decided not to use it for this purpose. In any case that shouldn't be a problem, because ravendb sdk already implements a Rep/UoW pattern.

What I think can be improved is error handling and logging. I have a really elegant way how I am doing that in c#, using middleware pipelines, where I am logging every request/response, duration of request, and a lot of other things.
The same thing is with error handling. I think those two things are very important, and I would probably ask some experienced java devs, what is best practice.

RavenDB indexes are very powerful, but I skipped it for this purpose, filtering is still very fast.

I would add paging in filtering because now the result can contain a lot of data.

Dependency injection is something that can be improved. 

I am using test instance for raven and you can see the data here, after you run the project:
http://live-test.ravendb.net/studio/index.html#databases/documents?&database=telemetry-test



## Tech Stack

**Server:** Java, RavenDB

## Prerequisites

- Java 17+
- Maven 3+

## Run Locally

Clone the project

```bash
  git clone https://github.com/djordjedjukic/telemetry-data-hub.git
```

Go to the project directory

```bash
  cd telemetry-data-hub
```

Start the server

```bash
  mvn spring-boot:run
```

## API Reference

#### Import telemetry data

```http
  POST /api/telemetry/import
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `file` | `MultipartFile` | CSV file you want to import |

#### Get all applicable filters

```http
  GET /api/telemetry/filters
```

#### Filter telemetry data

```http
  POST /api/telemetry/filter
```

The request body should be a JSON array of filter conditions. Each filter condition should have the following structure:

| Key       | Type     | Description                            |
| :-------- | :------- | :------------------------------------- |
| `fieldName`   | `string` | The name of the field to filter on. |
| `operator`| `string` | The operator to use for the filter (e.g., 'Equals', 'GreaterThan', 'LessThan', 'Contains'). |
| `value`   | `string` | The value to use for comparison. |

### Example

```json
POST /api/telemetry/filter
Content-Type: application/json

[
    {
        "fieldName": "engineSpeed",
        "operator": "GreaterThan",
        "value": 1000
    },
    {
        "fieldName": "serialNumber",
        "operator": "Equals",
        "value": "A5305041"
    }
]
