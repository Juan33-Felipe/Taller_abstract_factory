interface Wallet {
    void generarDireccion();
}

interface Transaction {
    void enviar(double monto);
}


class BitcoinWallet implements Wallet {
    @Override
    public void generarDireccion() {
        System.out.println("Direccion Bitcoin creada: aB2C3...");
    }
}

class BitcoinTransaction implements Transaction {
    @Override
    public void enviar(double monto) {
        System.out.println("Enviando " + monto + " Unidades procesadas");
    }
}

// --- CLASES CONCRETAS (ETHEREUM) ---
class EthereumWallet implements Wallet {
    @Override
    public void generarDireccion() {
        System.out.println("Direccion Ethereum creada: hFg123...");
    }
}

class EthereumTransaction implements Transaction {
    @Override
    public void enviar(double monto) {
        System.out.println("Enviando " + monto + " Unidades procesadas");
    }
}


interface CryptoFactory {
    Wallet createWallet();
    Transaction createTransaction();
}


class BitcoinFactory implements CryptoFactory {
    @Override
    public Wallet createWallet() { 
        return new BitcoinWallet(); 
    }
    
    @Override
    public Transaction createTransaction() { 
        return new BitcoinTransaction(); 
    }
}

class EthereumFactory implements CryptoFactory {
    @Override
    public Wallet createWallet() { 
        return new EthereumWallet(); 
    }
    
    @Override
    public Transaction createTransaction() { 
        return new EthereumTransaction(); 
    }
}


public class Abstract_factory {
    public static void main(String[] args) {
        // Ejemplo con Bitcoin
        CryptoFactory btcFactory = new BitcoinFactory();
        Wallet btcWallet = btcFactory.createWallet();
        Transaction btcTx = btcFactory.createTransaction();
        
        System.out.println("Bitcoin");
        btcWallet.generarDireccion();
        btcTx.enviar(0.05);

        System.out.println();

        // Ejemplo con Ethereum
        CryptoFactory ethFactory = new EthereumFactory();
        Wallet ethWallet = ethFactory.createWallet();
        Transaction ethTx = ethFactory.createTransaction();
        
        System.out.println("Ethereum ");
        ethWallet.generarDireccion();
        ethTx.enviar(1.2);
    }
}