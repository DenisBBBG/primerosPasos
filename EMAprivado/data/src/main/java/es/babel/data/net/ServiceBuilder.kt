package es.babel.data.net


import es.babel.data.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/*
Clase con la que se realiza la conexion con la API mediante retrofit
 */
class ServiceBuilder {
    companion object {
        fun getServiceBuilder(): Retrofit {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            val client = OkHttpClient.Builder().also {

                it.addInterceptor(UserKeyHeaderInterceptor(BuildConfig.USER_KEY ))
            }.addInterceptor(interceptor).build()
            return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }
    }

    private class UserKeyHeaderInterceptor(val userKey: String) :
            Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val newRequest = chain.request()
                .newBuilder()
                .addHeader(name = USER_KEY, value = userKey)
                .build()
            return chain.proceed(newRequest)
        }

        companion object {
            const val USER_KEY = "user-key"
        }
    }
}


