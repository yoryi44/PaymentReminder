import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.paymentreminder.statistics.presentation.models.Statistics

@Composable
fun HorizontalBarChartWithLabels(
    modifier: Modifier = Modifier,
    values: List<Statistics>,
    barColor: Color = MaterialTheme.colorScheme.primary,
    labelColor: Color = MaterialTheme.colorScheme.onPrimary
) {

    //SE SACA EL MONTO MAXIMO DE LOS PAGOS
    val maxValue: Float = values.maxOfOrNull { it.amount.toFloat() } ?: 1f

    //SE CREA EL CONTENEDOR DE LA PANTALLA
    Column(modifier = modifier.fillMaxSize()) {
        values.forEach { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                //SE CREA LA BARRA QUE REPRESENTARA LOS VALORES DE LOS PAGOS
                Box(
                    modifier = Modifier
                        .fillMaxWidth(fraction = (item.amount.toFloat() / maxValue))
                        .height(24.dp)
                        .background(barColor),
                    contentAlignment = Alignment.CenterStart
                ) {
                    //SE CREA EL TEXTO QUE VA EN LA BARRA CON NOMBRE Y VALOR
                    Text(
                        text = "${item.category} : ${item.amount}",
                        color = labelColor,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
    }
}

