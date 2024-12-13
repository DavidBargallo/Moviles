package es.tierno.david.bo.basededatos

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import es.tierno.david.bo.basededatos.data.ClienteDatabase
import es.tierno.david.bo.basededatos.data.ClienteEntity
import es.tierno.david.bo.basededatos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        lateinit var database: ClienteDatabase
        const val DATABASE_NAME = "clietne-db"
        private lateinit var binding: ActivityMainBinding
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MainActivity.database =  Room.databaseBuilder(this,
            ClienteDatabase::class.java,
            DATABASE_NAME).build()
    }


    fun guardar(view: View){

        val nombre: String = binding.tvNombre.text.toString()
        val apellidos: String = binding.tvApellidos.text.toString()
        val cliente = ClienteEntity(0, nombre,apellidos);
        val clienteDao = database.clienteDao()

        clienteDao.insert(cliente)

    }
}