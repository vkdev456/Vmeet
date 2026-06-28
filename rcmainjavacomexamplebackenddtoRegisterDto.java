[1mdiff --cc backend/src/main/java/com/example/backend/dto/RegisterDto.java[m
[1mindex 18e3b62,74b726e..0000000[m
[1m--- a/backend/src/main/java/com/example/backend/dto/RegisterDto.java[m
[1m+++ b/backend/src/main/java/com/example/backend/dto/RegisterDto.java[m
[36m@@@ -18,13 -18,7 +18,17 @@@[m [mpublic class RegisterDto [m
      public RegisterDto(){[m
          [m
      }[m
[32m++<<<<<<< HEAD[m
[32m +[m
[32m +    public RegisterDto(String name, String username, String password){[m
[32m +        this.name=name;[m
[32m +        this.username=username;[m
[32m +        this.password=password;[m
[32m +    }[m
[32m +[m
[32m++=======[m
[32m+     [m
[32m++>>>>>>> signup-login[m
      public String getName(){[m
           return name;[m
      }[m
