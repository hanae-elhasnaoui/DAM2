package es.elorrieta.gymapp
import android.graphics.Bitmap
import java.io.ByteArrayOutputStream
fun fotoBytes(bitmap:Bitmap):ByteArray {
    val salida=ByteArrayOutputStream()
    bitmap.compress(Bitmap.CompressFormat.JPEG,75,salida)
    return salida.toByteArray()
}
