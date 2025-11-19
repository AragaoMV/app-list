package br.com.aragao.marcos.lista

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.aragao.marcos.lista.ui.theme.ApplistaTheme
import br.com.aragao.marcos.lista.ui.theme.Marinho
import br.com.aragao.marcos.lista.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ApplistaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(verticalArrangement = Arrangement.Top) {
                        ImagemTopo(
                            modifier = Modifier.padding(
                                innerPadding
                            )
                        )
                        Titulo(
                            texto = "Lista de Compras", modifier = Modifier.padding(innerPadding)
                        )
                        Titulo(
                            texto = "Comprado", modifier = Modifier.padding(innerPadding)
                        )
                        ItemDaLista(
                            modifier = Modifier.padding(innerPadding)
                        )
                        Icone(
                            icone = Icons.Default.Edit, modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Titulo(texto: String, modifier: Modifier = Modifier) {
    Text(
        text = texto,
        style = Typography.headlineLarge,
        modifier = modifier,
    )
}

@Composable
fun ItemDaLista(modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.Top, modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Checkbox(
                checked = false,
                onCheckedChange = {},
                modifier = Modifier
                    .padding(8.dp)
                    .size(24.dp),
            )
            Text(
                text = "Suco",
                style = Typography.bodyMedium,
                textAlign = TextAlign.Start,
                modifier = Modifier.weight(1f),
            )
            Icone(
                icone = Icons.Default.Delete, modifier = Modifier
                    .padding(end = 8.dp)
                    .size(16.dp)
            )
            Icone(
                icone = Icons.Default.Edit, modifier = Modifier.size(16.dp)
            )
        }
        Text(
            text = "Segunda-feira (31/10/2022) às 08:30",
            style = Typography.labelSmall,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Composable
fun ImagemTopo(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.image_topo),
        contentDescription = null,
        modifier = modifier.size(160.dp)
    )
}

@Composable
fun Icone(icone: ImageVector, modifier: Modifier = Modifier) {
    Icon(
        icone, contentDescription = "Editar", modifier = modifier, tint = Marinho
    )
}


