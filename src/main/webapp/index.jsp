<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>UsersInc</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <div class="row align-items-center" >
        <div class="col">
            <h1>Welcome to the UsersInc</h1>

        </div>
    </div>

    <div class="row align-items-center">
        <div class="col">
            <h2>Registration Form</h2>
                <form action='/register' method='GET'>
                    <label for="name">Full Name:</label><br>
                    <input type='text' id='name' name='name'><br>


                    <label for="phone">Phone number:</label><br>
                    <input type='text' id='phone' name='phone'><br>


                    <label for="email">E-mail:</label><br>
                    <input type='text' id='email' name='email'><br>

                    <label for="city">City:</label><br>
                    <input type='text' id='city' name='city'><br>


                    <div class="row align-items-center">
                        <div class="col">
                        <button type='submit' class='btn btn-secondary'>Submit</button>
                        </div>
                    </div>


                    <div class="row align-items-center">
                        <div class="col">
                        <%
                        String name_e=" ";
                        String phone_e=" ";
                        String email_e=" ";
                        String city_e=" ";
                        try{
                        name_e=(String)request.getAttribute("name_e");
                        }
                        catch(Exception e){}
                        try{
                        phone_e=(String)request.getAttribute("phone_e");
                        }
                        catch(Exception e){}
                        try{
                        email_e=(String)request.getAttribute("email_e");
                        }
                        catch(Exception e){}
                        try{
                        city_e=(String)request.getAttribute("city_e");
                        }
                        catch(Exception e){}
                        %>
                        <h2><%=name_e%></h2>
                        <br>
                        <h2><%=phone_e%></h2>
                        <br>
                        <h2><%=email_e%></h2>
                        <br>
                        <h2><%=city_e%></h2>
                        <br>
                        </div>
                    </div>

                </form>

        </div>
    </div>

    <div class="row align-items-center">
        <div class="col">
            <a href="/viewAllUsers"><button type="button" class="btn btn-warning">Want to see the existing users ??</button></a>
        </div>
    </div>

</div>

</body>
</html>
