package mandelbrot;

import java.util.Iterator;
import java.util.function.Function;

/**
 * A class to compute the term of a sequence of complex numbers, generated
 * by a function <code>f</code> and an initial term <code>u_0</code>, such
 * that <code> u_{n+1} = f(u_n)</code>.
 * <p>
 * It implements <code>Iterable</code>, allowing to traverse the sequence
 * with <code>for (Complex z : mySequence)</code>
 */
public class Sequence implements Iterable<Complex> {

    /* The generating function */
    private final Function<Complex, Complex> f;

    /* The initial term */
    private final Complex u0;


    /**
     * Creates a sequence given the initial term and the function.
     *
     * @param u0 the first term of the sequence,
     * @param f  the function over complexes whose repeated application generates the sequence
     */
    Sequence(Complex u0, Function<Complex, Complex> f) {
        this.f = f;
        this.u0 = u0;
    }


    /**
     * Creates an iterator iterating all terms of the sequence in order.
     *
     * @return an iterator
     */
    @Override
    public Iterator<Complex> iterator() {
        return new SeqIterator();
    }

    private class SeqIterator implements Iterator<Complex> {
        private Complex current = u0;

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Complex next() {
            current = f.apply(current);
            return current;
        }
    }
}
