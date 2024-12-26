# v0.1 Basic Functions

## [dev] v0.1.1 llm

### Features

* Default generator using
  llm ([257418b](https://github.com/Scorpio4938/scribe/commit/257418be0c91d51e115ee8d5462c7d55f027eb18))
    * name
    * region name
    * descriptive text
* File Writer
* File Checkers

### Issues

* LLM cannot return:
    * code 404 with nothing in response
    * code 200 but cannot find model
        * This might due to the url linking process, as with java, using java's built-in HttpRequest and HttpResponse
          may direct to a different place than through using OpenAI SDK. And as the OpenAi SDK can direct the message
          via: 'openai.chat.completions', the directing using only HttpRequest may not lead to the actual point.

---

## [paused] v0.1.0 Setting Up

### Features

* Default Name generator
* File Readers ([0dda01c](https://github.com/Scorpio4938/scribe/commit/0dda01c4f3eb55d1878ccf1aa33a58e4afe20ba4))

### Issues

* The name generator may return differed String because of unicode issues