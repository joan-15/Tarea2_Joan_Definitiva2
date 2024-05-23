cmake_minimum_required(VERSION 3.4.1)

add_library( # Nombre de la biblioteca.
             native-lib

             # Define la biblioteca como una biblioteca compartida.
             SHARED

             # Proporciona una ruta relativa a tu archivo fuente.
             src/main/cpp/native-lib.cpp )

# Busca bibliotecas específicas del sistema y vincúlalas con la biblioteca nativa.
find_library( # Define el nombre de la variable de la biblioteca.
              log-lib

              # Especifica el nombre de la biblioteca que quieres buscar.
              log )

# Vincula tu biblioteca nativa con las bibliotecas encontradas.
target_link_libraries( # Especifica la biblioteca objetivo.
                       native-lib

                       # Enlaza la biblioteca objetivo con las bibliotecas log.
                       ${log-lib} )
