package com.example.myimmo

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.storage.Storage

object SupabaseClient {

    val client: SupabaseClient = createSupabaseClient(
        supabaseUrl = "https://qxjrylsttlwythcczxwp.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InF4anJ5bHN0dGx3eXRoY2N6eHdwIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NjIwODg0MTAsImV4cCI6MjA3NzY2NDQxMH0.uEOGHdY5Ml1-wwNJflw_bHK9BYbeIJP2W4Oy0WNaWNk"
    ) {
        install(Auth)
        install(Postgrest)
        install(Storage)
    }

}
