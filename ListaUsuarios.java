/*
 * The MIT License
 *
 * Copyright 2016 Josu Alvarez <jalvarez041.ehu.eus>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

import java.util.HashMap;
import java.util.Map;
import javax.swing.text.Keymap;

/**
 * @author Josu Alvarez <jalvarez041.ehu.eus>
 */
public class ListaUsuarios {

    private Map<String, char[]> lUsuarios;
    private static ListaUsuarios miListaUsuarios;

    private ListaUsuarios() {
        lUsuarios = new HashMap<>();
    }

    public static ListaUsuarios getMiListaUsuarios() {
        if (miListaUsuarios == null) {
            miListaUsuarios = new ListaUsuarios();
        }
        return miListaUsuarios;
    }

    public boolean esta(Usuario u) {
        boolean flag = false;
        if (this.lUsuarios.containsKey(u.getNombre())) {
            if (u.comprobarContraseña(this.lUsuarios.get(u.getNombre()))) {
                flag = true;
            }
        }
        return flag;
    }

    public void anadirUsuario(Usuario u) {
        if (this.esta(u)) {
            //mostramos error por pantalla
        } else {
            ListaUsuarios.getMiListaUsuarios().lUsuarios.put(u.getNombre(), u.getContrasena());
        }
    }
}

