package jpokedex.observers;

import java.util.Observer;

/**
 * Observer of selected pokemon. Should be implemented by a class, that should
 * be notified if the selected pokemon is changed. Changes include switching to
 * a totally different pokemon, as well as changes on the selected pokemon.
 *
 * @author grb19
 */
public interface SelectedPokemonObserver extends Observer {

}
