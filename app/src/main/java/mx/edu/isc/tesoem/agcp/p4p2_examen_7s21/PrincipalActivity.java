package mx.edu.isc.tesoem.agcp.p4p2_examen_7s21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import DatosExamen.EstructuraDatos;

public class PrincipalActivity extends AppCompatActivity {

    TextView txtpregunta;
    RadioButton r1, r2, r3;

    Button  btnant, btnsig, btncal;

    int Indice = 0; // Agrega esta variable para rastrear el índice de la pregunta actual
    int puntaje = 0;
    int respuestasCorrectas = 0;
    ArrayList<EstructuraDatos> listadatos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        txtpregunta = findViewById(R.id.txtpregunta);
        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);
        r3 = findViewById(R.id.r3);

        btnant = findViewById(R.id.btnant);
        btnsig = findViewById(R.id.btnsig);
        btncal = findViewById(R.id.btncal);

        EstructuraDatos ed = new EstructuraDatos();

        ed.setPregunta("1.- ¿Cuál es el planeta más grande del sistema solar?");
        ed.setR1("A) Venus");
        ed.setR2("B) Marte");
        ed.setR3("C)Júpiter");
        ed.setRc("C");
        listadatos.add(ed);
        ed = new EstructuraDatos();
        ed.setPregunta("2.- ¿Quién escribió la novela Cien años de soledad?");
        ed.setR1("A) Gabriel García Márquez");
        ed.setR2("B)  Mario Vargas Llosa");
        ed.setR3("C) Pablo Neruda");
        ed.setRc("A");
        listadatos.add(ed);
        ed = new EstructuraDatos();
        ed.setPregunta("3.- ¿En qué país se encuentra la Gran Muralla China?");
        ed.setR1("A)  India");
        ed.setR2("B)  China");
        ed.setR3("C) Corea del Sur");
        ed.setRc("B");
        listadatos.add(ed);
        ed = new EstructuraDatos();
        ed.setPregunta("4.- ¿Cuál es el río más largo del mundo?");
        ed.setR1("A) El Amazonas");
        ed.setR2("B) El Nilo");
        ed.setR3("C) El Mississippi");
        ed.setRc("A");
        listadatos.add(ed);
        ed = new EstructuraDatos();
        ed.setPregunta("5.- ¿Quién pintó la Mona Lisa?");
        ed.setR1("A) Pablo Picasso");
        ed.setR2("B) Vincent van Gogh");
        ed.setR3("C) Leonardo da Vinci");
        ed.setRc("C");
        listadatos.add(ed);
        ed = new EstructuraDatos();
        ed.setPregunta("6.- ¿Cuál es el metal más abundante en la corteza terrestre?");
        ed.setR1("A) Oro");
        ed.setR2("B) Plata");
        ed.setR3("C) Hierro");
        ed.setRc("C");
        listadatos.add(ed);
        ed = new EstructuraDatos();
        ed.setPregunta("7.- ¿Cuál es la capital de Canadá?");
        ed.setR1("A) Toronto");
        ed.setR2("B) Vancouver");
        ed.setR3("C) Ottawa");
        ed.setRc("C");
        listadatos.add(ed);
        ed = new EstructuraDatos();
        ed.setPregunta("8.- ¿Cuál es el océano más grande del mundo?");
        ed.setR1("A) Atlántico");
        ed.setR2("B) Pacífico");
        ed.setR3("C) Ártico");
        ed.setRc("B");
        listadatos.add(ed);
        ed = new EstructuraDatos();
        ed.setPregunta("9.- ¿Quién fue el primer presidente de los Estados Unidos?");
        ed.setR1("A) Thomas Jefferson");
        ed.setR2("B) George Washington");
        ed.setR3("C) John Adams");
        ed.setRc("B");
        listadatos.add(ed);
        ed = new EstructuraDatos();
        ed.setPregunta("10.- ¿Cuál es el país más grande del mundo en términos de superficie?");
        ed.setR1("A) Estados Unidos");
        ed.setR2("B) Canadá");
        ed.setR3("C) Rusia");
        ed.setRc("C");
        listadatos.add(ed);
        EstructuraDatos edm = listadatos.get(0);
        //Log.i("informacion", "valor: " + edm.getPregunta());
        txtpregunta.setText(edm.getPregunta());
        r1.setText(edm.getR1());
        r2.setText(edm.getR2());
        r3.setText(edm.getR3());

        btnsig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verifica si se ha seleccionado una respuesta antes de avanzar
                String respuestaSeleccionada = obtenerRespuesta();
                if (respuestaSeleccionada != null) {
                    listadatos.get(Indice).setRespuestaSeleccionada(respuestaSeleccionada);
                }

                Indice++;

                if (Indice < listadatos.size()) {
                    EstructuraDatos nextQuestion = listadatos.get(Indice);
                    txtpregunta.setText(nextQuestion.getPregunta());
                    r1.setText(nextQuestion.getR1());
                    r2.setText(nextQuestion.getR2());
                    r3.setText(nextQuestion.getR3());

                    // Limpia la selección de respuestas
                    r1.setChecked(false);
                    r2.setChecked(false);
                    r3.setChecked(false);
                }
            }
        });

        btnant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Indice--;

                if (Indice >= 0 && Indice < listadatos.size()) {
                    EstructuraDatos previousQuestion = listadatos.get(Indice);
                    txtpregunta.setText(previousQuestion.getPregunta());
                    r1.setText(previousQuestion.getR1());
                    r2.setText(previousQuestion.getR2());
                    r3.setText(previousQuestion.getR3());

                    // Limpia la selección de respuestas
                    r1.setChecked(false);
                    r2.setChecked(false);
                    r3.setChecked(false);
                }
            }
        });


        btncal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Califica la pregunta actual si se ha seleccionado una respuesta
                if (Indice >= 0 && Indice < listadatos.size()) {
                    EstructuraDatos preguntaActual = listadatos.get(Indice);
                    String respuestaSeleccionada = obtenerRespuesta();

                    if (respuestaSeleccionada != null) {
                        preguntaActual.setRespuestaSeleccionada(respuestaSeleccionada);
                    }
                }
                puntaje = 0; // Reinicia el puntaje cada vez que se califica
                respuestasCorrectas = 0; // Reinicia el contador de respuestas correctas

                // Califica todas las preguntas y cuenta las respuestas correctas
                for (EstructuraDatos pregunta : listadatos) {
                    String respuestaSeleccionadaPregunta = pregunta.getRespuestaSeleccionada();

                    if (respuestaSeleccionadaPregunta != null) {
                        if (respuestaSeleccionadaPregunta.equals(pregunta.getRc())) {
                            // Respuesta correcta
                            puntaje++; // Aumenta el puntaje
                            respuestasCorrectas++;
                        }
                    }
                }
                Toast.makeText(PrincipalActivity.this, "Puntaje total: " + puntaje + " de 10 preguntas. Respuestas correctas: " + respuestasCorrectas, Toast.LENGTH_LONG).show();
            }
        });
    }

    private String obtenerRespuesta() {
        if (r1.isChecked()) {
            return "A";
        } else if (r2.isChecked()) {
            return "B";
        } else if (r3.isChecked()) {
            return "C";
        } else {
            return null; // Ninguna respuesta seleccionada
        }
    }

}