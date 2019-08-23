<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>
</head>
<body>

<div id="content" role="main">
        <h1>GRELLO!!</h1>
        <h1>Something from config: ${grailsApplication.config.grello.message}</h1>
        <h1>User List from DB</h1>
        <f:table collection="${userList}" />
</div>
</body>
</html>
